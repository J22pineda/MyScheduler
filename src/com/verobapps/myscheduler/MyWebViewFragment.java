package com.verobapps.myscheduler;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.*;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import de.keyboardsurfer.android.widget.crouton.Crouton;


public class MyWebViewFragment extends Fragment {

	private WebView mWebView;
	private boolean mIsWebViewAvailable;

	private ProgressBar progressBar;

    /**
     * Creates a new fragment which loads the supplied url as soon as it can
     */
	public static MyWebViewFragment newInstance() {
		MyWebViewFragment fragment = new MyWebViewFragment();

		return fragment;
	}

	/**
	 * Called to instantiate the view. Creates and returns the WebView.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		setRetainInstance(true);
		if (mWebView != null) {
			mWebView.destroy();
		}

		mWebView = new WebView(getActivity());

		mWebView.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
					if(mWebView.canGoBack()){
						mWebView.goBack();
					}
					
					return true;
				}
				return false;
			}

		});

		progressBar = (ProgressBar) getActivity()
				.findViewById(R.id.progressBar);

		slideIn();

		mWebView.setWebChromeClient(new WebChromeClient() {

            public boolean onConsoleMessage(ConsoleMessage cmsg){
                //ADDED WORK AROUND FOR 3rd WEEK SCHEDULE
                // check secret prefix
                if (cmsg.message().startsWith("MAGIC"))
                {
                    String msg = cmsg.message().substring(5); // strip off prefix

                    MyWebViewActivity.SCHEDULE_HTML = msg;

                    return true;
                }

                return false;
            }
            // END WORK AROUND

			public void onProgressChanged(WebView view, int progress) {
				progressBar.setProgress(progress);
				if (progress == 100) {
					slideOut();
				}
			}
		});

		mWebView.setWebViewClient(new InnerWebViewClient());
		mWebView.loadUrl(MyWebViewActivity.SCHEDULE_LINK);
		mIsWebViewAvailable = true;
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setBuiltInZoomControls(true);
		settings.setDisplayZoomControls(false);
		settings.setUseWideViewPort(true);
		settings.setLoadWithOverviewMode(true);

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		mWebView.setLayoutParams(params);

		return mWebView;
	}

	private void slideIn() {

		AnimatorSet set = new AnimatorSet();
		set.playTogether(
				// animate from off-screen in to screen
				ObjectAnimator.ofFloat(progressBar, "translationY", -11, 0),
				ObjectAnimator.ofFloat(mWebView, "translationY", 0, 9)

		);
		set.setStartDelay(0);
		set.setDuration(250).start();

	}

	private void slideOut() {

		AnimatorSet set = new AnimatorSet();
		set.playTogether(
				// animate from on-screen and out
				ObjectAnimator.ofFloat(progressBar, "translationY", -11),
				ObjectAnimator.ofFloat(mWebView, "translationY", 0));
		set.setStartDelay(0);
		set.setDuration(250).start();

	}


	/**
	 * Called when the fragment is visible to the user and actively running.
	 * Resumes the WebView.
	 */
	@Override
	public void onPause() {
		super.onPause();
		mWebView.onPause();
	}

	/**
	 * Called when the fragment is no longer resumed. Pauses the WebView.
	 */
	@Override
	public void onResume() {
		mWebView.onResume();
		super.onResume();
	}

	/**
	 * Called when the WebView has been detached from the fragment. The WebView
	 * is no longer available after this time.
	 */
	@Override
	public void onDestroyView() {
		mIsWebViewAvailable = false;
		Crouton.cancelAllCroutons();
		super.onDestroyView();

	}

	/**
	 * Called when the fragment is no longer in use. Destroys the internal state
	 * of the WebView.
	 */
	@Override
	public void onDestroy() {
		if (mWebView != null) {
			mWebView.destroy();
			mWebView = null;
		}
		super.onDestroy();
	}


	/* To ensure links open within the application */
	private class InnerWebViewClient extends WebViewClient {

        //ADDED WORK AROUND FOR 3rd WEEK SCHEDULE
        public void onPageFinished(WebView view, String address)
        {
            // have the page spill its guts, with a secret prefix
            view.loadUrl("javascript:console.log('MAGIC'+document.getElementsByTagName('html')[0].innerHTML);");
        }

        //END WORK AROUND


		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			view.loadUrl(url);
			slideIn();

			return true;
		}
	}

}
