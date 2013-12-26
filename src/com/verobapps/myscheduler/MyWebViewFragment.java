package com.verobapps.myscheduler;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import de.keyboardsurfer.android.widget.crouton.Crouton;


public class MyWebViewFragment extends Fragment {

	private WebView mWebView;
	private boolean mIsWebViewAvailable;
	Activity activity;

	private ProgressBar progressBar;

	/**
	 * Creates a new fragment which loads the supplied url as soon as it can
	 * 
	 * @param url
	 *            the url to load once initialised
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
						WebBackForwardList history = mWebView.copyBackForwardList();
						MyWebViewActivity.SCHEDULE_LINK = history.getItemAtIndex(history.getCurrentIndex() - 1).getOriginalUrl();
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
	 * Convenience method for loading a url. Will fail if {@link View} is not
	 * initialised (but won't throw an {@link Exception})
	 * 
	 * @param url
	 */
	public void loadUrl(String url) {
		if (mIsWebViewAvailable) {

			getWebView().loadUrl(MyWebViewActivity.SCHEDULE_LINK = url);
		}
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

	/**
	 * Gets the WebView.
	 */
	public WebView getWebView() {
		return mIsWebViewAvailable ? mWebView : null;
	}

	/* To ensure links open within the application */
	private class InnerWebViewClient extends WebViewClient {
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			MyWebViewActivity.SCHEDULE_LINK = url;
			slideIn();

			return true;
		}
	}

}
