package com.verobapps.myscheduler;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility class
 */
public class Util {

    public static String DEBUG_MYSCHEDULER = "debug_myscheduler";
    public static int JSOUP_TIMEOUT = 30000;

    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";

    /*
    *   This will determine the size of the status bar
    *
    *   @res The activity's current resources
    *   @key String needed to identify the resource
    *
    */
    private static int getInternalDimensionSize(Resources res, String key) {
        int result = 0;
        int resourceId = res.getIdentifier(key, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /*
    * Will set the color of the view under the transparent status bar so it matches the action bar
    *
    * @activity The current Activity
    *
    */

    public static void setSystemBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            Window win = activity.getWindow();
            ViewGroup decorViewGroup = (ViewGroup) win.getDecorView();

            View mStatusBarTintView = new View(activity);
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, getInternalDimensionSize(activity
                    .getResources(), STATUS_BAR_HEIGHT_RES_NAME));
            params.gravity = Gravity.TOP;

            mStatusBarTintView.setLayoutParams(params);
            mStatusBarTintView.setBackgroundColor(activity.getResources().getColor(R.color.status_bar_blue));
            decorViewGroup.addView(mStatusBarTintView);


        }
    }


    // Adds days to Date object
    public static Calendar addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal;
    }

    static String tempHTML = "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- Epicentric Foundation Server -->\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<html>\n" +
            "<head>\n" +
            "\n" +
            "\n" +
            "\t\t<title>Integrated Schedule View</title>\n" +
            "\n" +
            "<!-- GLOBAL STYLESHEET -->\n" +
            "\t<link rel=\"stylesheet\" href=\"/css/ppf/team/newteam_common.css\" type=\"text/css\" />\n" +
            "<!-- MAIN IMPORT -->\n" +
            "\t<link rel=\"stylesheet\" href=\"/davpublish/wdpr/portal_styles/css/WDPR_main.css\" type=\"text/css\" />\t\n" +
            "<!-- PRINT STYLESHEET -->\n" +
            "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/davpublish/wdpr/portal_styles/css/WDPR_print.css\" media=\"print\" />\n" +
            "\t\n" +
            "\t<base target=\"_top\">\n" +
            "\n" +
            "<!-- CODE FROM CORPORATE TO MAKE THE MOVIE AND SLIDESHOW WORK ON THE HOME TAB -->\n" +
            "<script type=\"text/javascript\" src=\"/js/mdt/flashobject.js\"></script>\n" +
            "\n" +
            "<!-- CODE TO ACTIVATE FLASH OBJECTS -->\n" +
            "<script src=\"/davpublish/wdpr/portal_styles/scripts/AC_RunActiveContent.js\" type=\"text/javascript\" ></script>\n" +
            "\n" +
            "<!-- CODE TO SUPPORT FLASH LOGIN BADGE -->\n" +
            "<script src=\"/davpublish/wdpr/portal_styles/scripts/badgeSupport.js\" type=\"text/javascript\" ></script>\n" +
            "\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "\t<body style=\"font-size:70%;\" topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" +
            "\t\n" +
            "\t\t\n" +
            "\t\t<!-- Start Grid Table -->\n" +
            "\t\t\n" +
            "\t\t<table class=\"grid\" id=\"pageHeader\" border=\"0\" description=\"This table is for page layout - header\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"124\">\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"headerStyle\" >\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- In DEP Header Style Type header file -->\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- End of DEP Header Style Type header file -->\n" +
            "\n" +
            "\n" +
            "<!--\n" +
            "This script monitors the close action on IE browser and ask the user for logoff confirmation. Shant\n" +
            "-->\n" +
            "<script src='/js/logoff_monitor/logoff.js'></script>\n" +
            "\n" +
            "\n" +
            "\t\n" +
            "\t\t\n" +
            "\n" +
            "\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!--  servletpath -->\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\n" +
            "        <!-- GGonzalez 8/15/2011 - JQuery Upgrade  -->\n" +
            "        <!-- GGonzalez 10/24/2011 - Badge / Admin Access Fix  -->\n" +
            "        <!--  SVasilko 11/2/2011 - Fixing Flip link -->\n" +
            "        <!-- SVasilko 12/2011 - bug fix for stray /site in header  -->\n" +
            "        \n" +
            "        <!--[if IE 6]>\n" +
            "\t\t\t<link rel=\"stylesheet\" stype=\"text/css\" href=\"/davpublish/wdpr/portal_styles/css/badge_ie6.css\" />\n" +
            "\t\t<![endif]-->\n" +
            "\t\t<script src=\"/davpublish/wdpr/resources/jquery/jquery-1.6.1.min.js\" type=\"text/javascript\"></script>\n" +
            "\t\t<script type=\"text/javascript\">           \n" +
            "\t\t<!--          \n" +
            "\t\t$(document).ready(\n" +
            "\t\t\t\tfunction(){            \n" +
            "\t            \t$(\".slidingDiv\").show();\n" +
            "\t                $(\".slidingDiv2\").hide();\n" +
            "\t\t                            \n" +
            "\t\t            });    \n" +
            "\t\t            function flip1() { \n" +
            "\t\t                    $(\".slidingDiv\").slideToggle('slow');\n" +
            "\t\t                    $(\".slidingDiv2\").hide();\n" +
            "\t\t                    $(\".slidingDiv\").show();\n" +
            "\t\t            } \n" +
            "\t\t            function flip2() { \n" +
            "\t\t                    $(\".slidingDiv2\").slideToggle('slow');\n" +
            "\t\t                    $(\".slidingDiv\").hide();\n" +
            "\t\t                    $(\".slidingDiv2\").show();\n" +
            "\t\t            }\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t            function isNull(check){\n" +
            "\t\t            \tvar nNull = false\n" +
            "\t\t            \tif(check == 'null'){ nNull = true;}\n" +
            "\t\t            \tif(check == null){ nNull = true;}\n" +
            "\t\t            \tif(check == ''){ nNull = true;}\n" +
            "\t\t            \treturn nNull\n" +
            "\t\t            }\n" +
            "\t\t            function help_openWindow( moduleId, height, width ) {\n" +
            "\t\t            \tvar linkz = \"/beans/common/help/jsp/process_helpview.jsp?beanID=tdo\";\n" +
            "\t\t            \tlinkz     = linkz + \"&defaultId=1043\";\n" +
            "\t\t            \tlinkz     = linkz + \"&moduleId=\"  + moduleId;\n" +
            "\t\t            \tif (isNull(height)) { height = \"400\"; }\n" +
            "\t\t            \tif (isNull(width)) { width  = \"400\"; }\n" +
            "\t\t            \tvar windz = \"\";\n" +
            "\t\t            \twindz = windz + \"height=\"  + height;\n" +
            "\t\t            \twindz = windz + \",width=\"  + width;\n" +
            "\t\t            \twindz = windz + \",toolbar=no,resizable=yes,status=no,location=no,scrollbars=yes\";\n" +
            "\t\t            \twindow.open(linkz, 'help', windz);\n" +
            "\t\t            }\n" +
            "\t\t        \n" +
            "\t\t\n" +
            "\t\tfunction help_openWindow( moduleId, height, width )\n" +
            "\t\t{\n" +
            "\t\t\tvar linkz = \"/beans/common/help/jsp/process_helpview.jsp?beanID=tdo\";\n" +
            "\t\t\tlinkz     = linkz + \"&defaultId=\" + \"1043\";\n" +
            "\t\t\tlinkz     = linkz + \"&moduleId=\"  + moduleId;\n" +
            "\t\t\n" +
            "\t\t\tvar windz = \"\";\n" +
            "\t\t\twindz = windz + \"height=\"  + height;\n" +
            "\t\t\twindz = windz + \",width=\"  + width;\n" +
            "\t\t\twindz = windz + \",toolbar=no,resizable=yes,status=no,location=no,scrollbars=yes\";\n" +
            "\t\t\n" +
            "\t\t\twindow.open(linkz, 'help', windz);\n" +
            "\t\t}\n" +
            "\t\t-->\n" +
            "\t\t</script>\n" +
            "<!-- Start Header Table -->\n" +
            "\n" +
            "<input type=\"hidden\" id=\"site\" value=\"dlr\" />\n" +
            "<script src=\"/davpublish/wdpr/portal_styles/banners/dynamic/dynamicBanner.js\"></script>\n" +
            "\n" +
            "<table description=\"This table is for 12HUB_WDPR_header layout.\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\n" +
            "\t<tr style=\"height:105px;\">\n" +
            "\t\t<td style=\"height:105px;\">\n" +
            "\t\t<div id=\"dlrBanner\"></div>\t\n" +
            "\t\t\n" +
            "\t\t<div id=\"Badge\" class=\"Badge\"> \n" +
            "\t\t\t\n" +
            "\t\t\t\n" +
            "\t\t\t<div id=\"authInfo\" class=\"slidingDiv\">\n" +
            "\t\t\t\t<div class=\"myI\"><a href=\"#\" onclick=\"flip2();\"><img src=\"/davpublish/wdpr/resources/common/badge/myI.png\"></a></div>\n" +
            "\t\t\t\t<h1>Welcome, Javier</h1>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/site/dlr/index.jsp?epi-content=SIGNOUT\" id=\"signoutLink\" title=\"Sign Out of the Hub\">Sign Out</a></li>\n" +
            "\t\t\t\t\t<li><a href=\"/site/dlr/index.jsp?epi-content=CHANGE_PASSWORD\" id=\"changepassLink\" title=\"Change Your Password\">Change Password</a></li>\n" +
            "\t\t\t\t\t<li><a href=\"/site/dlr/index.jsp?epi-content=LANGUAGE\" id=\"changelangLink\" title=\"Change Your Default Language\">Change Language</a></li>\n" +
            "\t\t\t\t\t<li><a href=\"/site/dlr/index.jsp?epi-content=ADD_CONTENT\" id=\"addmodLink\" title=\"Add a module to this tab\">Add Module</a></li>\n" +
            "\t\t\t\t</ul>\n" +
            "\t\t\t\t<ul class=\"login\">\n" +
            "\t\t\t\t\t<li><a href=\"#\" onclick=\"help_openWindow('1043',350,600);\" id=\"help2Link\" title=\"Help\">Help</a></li>\n" +
            "\t\t\t\t\t<li><a href=\"/site/dlr/index.jsp?epi-content=GENERIC&beanID=226&viewID=resetform&displayname=Feedback_Form\" id=\"contactLink\" title=\"Contact Us\">Contact Us</a></li>\n" +
            "\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</ul>\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<div id=\"userBadgeData\" class=\"slidingDiv2\">\n" +
            "\t\t\t\t<div class=\"myI\"><a href=\"#\" onclick=\"flip1();\"><img src=\"/davpublish/wdpr/resources/common/badge/myI_2.png\"></a></div>\n" +
            "\t\t\t\t<h1>Welcome, Javier</h1>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li title=\"Personnel Number\">Pernr: 00386186&nbsp;</li>\n" +
            "\t\t\t\t\t<li title=\"Personnel Area\">PA# 0113&nbsp;</li>\n" +
            "\t\t\t\t\t<li title=\"Business Area\">Business Area: 101&nbsp;</li>\n" +
            "\t\t\t\t\t<li title=\"Organizational Unit\">Org Unit: 10001021&nbsp;</li>\n" +
            "\t\t\t\t\t<li title=\"Cost Center\">Cost Center: 0005100679&nbsp;</li>\n" +
            "\t\t\t\t</ul>\n" +
            "\t\t\t\n" +
            "\t\t\t</div>\n" +
            "\t\t\t\n" +
            "\t\t</div><!-- END BADGE -->\n" +
            "\t\t</td>\n" +
            "\t</tr>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t<!-- Begin Horizontal Navigation Area -->\n" +
            "\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t<td valign=\"bottom\"  align=\"left\" colspan=\"2\">\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t<!-- Tabs - begins -->\n" +
            "\t\t\t\t\t\t\t\t<table class=\"tabs\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
            "\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/&' title='Disneyland Resort'>Disneyland Resort</a></td>\n" +
            "\n" +
            "\t\t\t\t\t<td valign='middle' class='TabOn' style='background:url(/images/wdw/theHub/dk_blue_tab.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.427e06f258729e615927f59354276099/&' title='Work'>Work</a></td>\n" +
            "\n" +
            "\t\t\t\t\t\t<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.7d9d49e64fc2cae0c9d358250aac01ca/&' title='Personal'>Personal</a></td>\n" +
            "\n" +
            "\t\t\t\t\t\t<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/onesourcedlr/menuitem.34d89a4394ad66884f9ce51077e26099/&' title='Guest'>Guest</a></td>\n" +
            "\n" +
            "\t\t\t\t\t\t<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.682fd220d3b173055d3522870bac01ca/&' title='Cast'>Cast</a></td>\n" +
            "\n" +
            "\t\t\t\t\t\t<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/team/menuitem.c88bc58a6af5447ab8588a1608e26099/?' title='TWDC'>TWDC</a></td>\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t\t\t<!-- Colspan needs to match number of tabs-->\n" +
            "\t\t\t\t\t\t\t\t\t\t<td colspan=6 id=\"secondNav\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"/site/wdpr/?epi_menuItemID=d456d249f4e117c8382393a6faac01ca&epi_menuID=2f6704979bb06b9870d35825faac01ca&epi_baseMenuID=2f6704979bb06b9870d35825faac01ca&\" style=\"color:white;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;  text-decoration: none;text-transform: capitalize;\">\n" +
            "\t\tWalt Disney Parks and Resorts</a> | \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\t\t\t\tDisneyland Resort | \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"/site/wdw/?epi_menuItemID=6fe1735dccd1b42a677a0f05f9ac01ca&epi_menuID=eebc48d7208955615727f59354276099&epi_baseMenuID=eebc48d7208955615727f59354276099&\" style=\"color:white;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;  text-decoration: none;text-transform: capitalize;\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\tWalt Disney World</a> | \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<a href=\"/site/wdi/?epi_menuItemID=324987cb21a72466b701ca150aac01ca&epi_menuID=9c8cc5318a206726547a0f05f9ac01ca&epi_baseMenuID=9c8cc5318a206726547a0f05f9ac01ca&\" style=\"color:white;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;  text-decoration: none;text-transform: capitalize;\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\tImagineering</a><br>\n" +
            "\t\n" +
            "\t\t\t\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t</table>\n" +
            "\t\t\t\t\t\t\t\t<!-- Tabs - ends -->\n" +
            "\n" +
            "\t\n" +
            "\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t<!-- horizontal navigation - ends -->\n" +
            "\t\t\t\t\t</table>\n" +
            "\t\t\t\t\t<!-- end header table -->\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\n" +
            "\t\t<table class=\"grid\" id=\"pageContent\" description=\"This table is for page layout.\" cellpadding=\"0\" cellspacing=\"0\">\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td valign=\"top\" class=\"pageContent\" >\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t<!-- Begin pageContent -->\n" +
            "\t\t\t\t\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n" +
            "  <tr>\n" +
            "    <td width=\"100%\">\n" +
            "\t  \n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- this is where page controls are normally inserted, -->\n" +
            "<!-- but page controls have been moved into the site    -->\n" +
            "<!-- controls style in the Quick Access Panel.          -->\n" +
            "\t</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"100%\" style=\"padding:15px\">\n" +
            "\n" +
            "\t    \n" +
            "\t    \n" +
            "\t      \n" +
            "\t        \n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<link type=\"text/css\" HreF=\"/davpublish/wdpr/resources/ehh/css/integratedView.css\" rel=\"stylesheet\" />\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/jquery/jquery-1.8.2.min.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"/dsfpublishing/wdpr/resources/common/jquery-ui-1.10.2/jquery-19.1.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/common/jquery-ui-1.10.2/ui/minified/jquery.ui.widget.min.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/common/jqplot/jquery.jqplot.min.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/common/jqplot/excanvas.js\"></script>\n" +
            "<script type=\"text/javascript\">var $j = jQuery.noConflict();</script>\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/ehh/scripts/integratedView.js\"></script>\t\n" +
            "\n" +
            "\n" +
            "<div id=\"trueTop\"></div>\n" +
            "<input type=\"hidden\" name=\"oldAsUser\" id=\"oldAsUser\" value=\"\"/>\n" +
            "<input type=\"hidden\" name=\"oldAsPerner\" id=\"oldAsPerner\" value=\"\"/>\n" +
            "<form id=\"universalForm\" action=\"/site/dlr/template.MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet.tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252FsubmitAnywhereViaJavascript&beanID=1406643234&viewID=maximized&javax.portlet.begCacheTok=com.vignette.cachetoken&javax.portlet.endCacheTok=com.vignette.cachetoken\">\n" +
            "\t<input type=\"hidden\" name=\"siteName\" value=\"DLR\" id=\"siteName\">\n" +
            "\t<input type=\"hidden\" name=\"userLocation\" value=\"unknown\" id=\"userLocation\">\n" +
            "\t<input type=\"hidden\" name=\"userNameUpper\" value=\"PINEJ034\" id=\"asUserNameUpper\">\n" +
            "\t<input type=\"hidden\" name=\"pernr\" value=\"00386186\" id=\"asPerner\">\n" +
            "\t<input type=\"hidden\" name=\"firstName\" value=\"Javier\" id=\"asFirstName\">\n" +
            "\t<input type=\"hidden\" name=\"lastName\" value=\"Pineda\" id=\"asLastName\">\n" +
            "\t<input type=\"hidden\" name=\"persArea\" value=\"0113\" id=\"asPersArea\">\n" +
            "\t<input type=\"hidden\" name=\"orgUnit\" value=\"02\" id=\"asOrgUnit\">\n" +
            "\t<input type=\"hidden\" name=\"costCenter\" value=\"10001021\" id=\"asCostCenter\">\n" +
            "\t<input type=\"hidden\" name=\"userNameUpper\" value=\"PINEJ034\" id=\"userNameUpper\">\n" +
            "\t<input type=\"hidden\" name=\"pernr\" value=\"00386186\" id=\"perner\">\n" +
            "\t<input type=\"hidden\" name=\"firstName\" value=\"Javier\" id=\"firstName\">\n" +
            "\t<input type=\"hidden\" name=\"lastName\" value=\"Pineda\" id=\"lastName\">\n" +
            "\t<input type=\"hidden\" name=\"persArea\" value=\"0113\" id=\"persArea\">\n" +
            "\t<input type=\"hidden\" name=\"orgUnit\" value=\"02\" id=\"orgUnit\">\n" +
            "\t<input type=\"hidden\" name=\"costCenter\" value=\"10001021\" id=\"costCenter\">\n" +
            "\t<input type=\"hidden\" name=\"todayString\" value=\"Mon 10/14\" id=\"todayString\">\n" +
            "\t<input type=\"hidden\" name=\"currentId\" value=\"\" id=\"currentId\">\n" +
            "<input type='hidden' name='javax.portlet.tpst' value='65fa5153808737f60d9cab10b5e26099_ws_MX'/><input type='hidden' name='javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID' value='maximized'/><input type='hidden' name='javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate' value='%2FEHHLSM%2FsubmitAnywhereViaJavascript'/><input type='hidden' name='beanID' value='1406643234'/><input type='hidden' name='viewID' value='maximized'/><input type='hidden' name='javax.portlet.begCacheTok' value='com.vignette.cachetoken'/><input type='hidden' name='javax.portlet.endCacheTok' value='com.vignette.cachetoken'/></form>\n" +
            "<table id=\"universalCalTable\" class=\"universalCalTable\"><tr><td valign=\"top\">\n" +
            "<div id=\"topMessage2\"><area name='area' id='area' cols='25' rows='5'><div style='border-style:solid;border-width:3px;width:210px;border-color:#666699;BACKGROUND-COLOR:#FFFFE0'><center><strong>Current date (<script type='text/javascript'>var d=new Date();document.write((d.getMonth()+1) +'/'+ d.getDate() +'/'+ d.getFullYear());</script>) does not reflect any day of schedule changes.</strong></center></div><div id='failedChangeUser'>The information you entered is invalid. Please try again.</div></area></div>\n" +
            "<div id=\"errorArea\" class=\"ErrorMessageText\"></div>\n" +
            "<div class=\"successMsg\" id=\"SuccessMessageText\"></div>\n" +
            "<div id=\"LSMQuickAccessPanel\">\n" +
            "<div id=\"nameDetail\"></div>\n" +
            "<div id=\"quickAccessTitle\" class=\"quickAccessTitle\"><h2>Workforce Management Links</h2></div>\n" +
            "\n" +
            "\t<ul id=\"quickAccessList\" class=\"quickAccessList\">\n" +
            "\t\t\n" +
            "\t\t\t\n" +
            "\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<li class=\"quickAccessBullet\"><a href=\"https://enterpriseportal.disney.com/site/dlr/menuitem.427e06f258729e615927f59354276099/index.jsp?epi-content=GENERIC&beanID=2023815463&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=etmdetailview.jsp%3FcontentId%3D457049%26xslFile%3Dwdw_collectioncontainer_fullscreen.xsl%26expDepth%3D2%26xslLoc%3Dcommon%26displayname%3DRequest+Schedules%2C+Vacations%2C+Pay&wsrp-windowState=wsrp:maximized\" onclick=\"helpLinkLoad('<b>RSVP</b>')\" target=\"_newWindow\" title=\"RSVP\"><b>RSVP</b></a></li>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\n" +
            "\t\t\n" +
            "\t\t\t\n" +
            "\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<br/>\n" +
            "\t\t\t\n" +
            "\t\t\n" +
            "\t</ul>\n" +
            "\t\n" +
            "\t\n" +
            "\n" +
            "\t\n" +
            "</div>\n" +
            "</td>\n" +
            "<td valign=\"top\" id=\"calendarCell\" class=\"calendarCellStyle\">\n" +
            "\t\n" +
            "<table><tr><td id=\"topMessageCell\"></td><td id=\"printMessageCell\"><div id=\"printDiv\" class=\"print_caller\"><a href='#' id='printAnchor'><strong>PRINT</strong> <img src='/davpublish/wdpr/resources/ehh/images/smallGreenPrint.bmp' alt='Print Schedule' /></a></div></td></tr></table>\n" +
            "\n" +
            "\n" +
            "<form name=\"CalForm\" id=\"ViewMyScheduleForm\" method=\"post\" action=\"/site/dlr/template.MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet.tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252FViewCalendar.do%253Bjsessionid%253D4DAC8D604E52939AC034C34C8F313E69&beanID=1406643234&viewID=maximized&javax.portlet.begCacheTok=com.vignette.cachetoken&javax.portlet.endCacheTok=com.vignette.cachetoken\">\n" +
            "\t<input type=\"hidden\" name=\"method\" value=\"loadViewMySchedule\" id=\"changeCalMethod\">\n" +
            "\t<input type=\"hidden\" name=\"asUser\" value=\"PINEJ034\">\n" +
            "\t<input type=\"hidden\" name=\"asPerner\" value=\"00386186\">\n" +
            "\t<input type=\"hidden\" name=\"searchPopFlag\" value=\"false\" id=\"searchPopFlag\">\n" +
            "\t<input type=\"hidden\" name=\"areaId\" value=\"\" id=\"searchAreaId\">\n" +
            "\t<input type=\"hidden\" name=\"propertyId\" value=\"\" id=\"searchPropertyId\">\n" +
            "\t<input type=\"hidden\" name=\"lobId\" value=\"\" id=\"searchLobId\">\n" +
            "\t<input type=\"hidden\" name=\"startDate\" value=\"10/14/2013\" id=\"searchShiftDate\">\n" +
            "\t<input type=\"hidden\" name=\"action\" value=\"\" id=\"action\">\n" +
            "\t<input type=\"hidden\" name=\"calOffset\" value=\"0\" id=\"calOffset\">\n" +
            "    <table id=\"navTableTop\"><tr><td id=\"etmMessageCellTop\">\n" +
            "    <div class=\"etmDiv\">\n" +
            "\t\t\t\t<a href='#workbrainMessage' name='modal'><strong>View My Time Details</strong></a>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t</div></td>\n" +
            "\t\t\t\t<td id=\"nextMessageCellTop\"><div class=\"nextDiv\">\n" +
            "\t\t\t\t<strong>Next Week</strong>\n" +
            "\t\t\t\t<a href='#' onclick='doNext();' id='nextLink'><img src='/davpublish/wdpr/resources/xpressForms/images/designer/moveRight.png' alt='Move forward a week' /></a>\n" +
            "\t\t\t</div></td></tr></table>\n" +
            "\t<div id=\"tablewrapper\">\n" +
            "\t    \t<div id=\"tableheader\">\n" +
            "\t\t\t<div class=\"details\"></div>\n" +
            "\t\t\t<div class=\"newForm\"></div>\n" +
            "\t\t\t</div>\n" +
            "\n" +
            "\n" +
            "<div id=\"dayTitle1\"><h2>Previous Week - 10/06/2013 to 10/12/2013</h2></div>\n" +
            "\t\t<table class=\"weekDisplay\" id=\"weekDisplay1\">\n" +
            "\t\t\t<tr id=\"calHeader\" class=\"calHeader\">\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Sun 10/06</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Mon 10/07</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Tue 10/08</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Wed 10/09</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Thu 10/10</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Fri 10/11</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Sat 10/12</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"history\" id=\"pastShifts0\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c0\" name=\"date0\" value=\"Sun 10/06\" />\n" +
            "\t\t\t\t<div id=\"cellDiv0\"></div><br/>\n" +
            "\t\t\t\t<div id=\"wbDiv0\"><div id='etmCellDiv0' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c0'>View Time Details</a></div></div>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"pastShifts1\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c1\" name=\"date1\" value=\"Mon 10/07\" />\n" +
            "\t\t\t\t<div id=\"cellDiv1\"></div><br/>\n" +
            "\t\t\t\t<div id=\"wbDiv1\"><div id='etmCellDiv1' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c1'>View Time Details</a></div></div>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"pastShifts2\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c2\" name=\"date2\" value=\"Tue 10/08\" />\n" +
            "\t\t\t\t<div id=\"cellDiv2\"></div><br/>\n" +
            "\t\t\t\t<div id=\"wbDiv2\"><div id='etmCellDiv2' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c2'>View Time Details</a></div></div>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"pastShifts3\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c3\" name=\"date3\" value=\"Wed 10/09\" />\n" +
            "\t\t\t\t<div id=\"cellDiv3\"></div><br/>\n" +
            "\t\t\t\t<div id=\"wbDiv3\"><div id='etmCellDiv3' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c3'>View Time Details</a></div></div>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"pastShifts4\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c4\" name=\"date4\" value=\"Thu 10/10\" />\n" +
            "\t\t\t\t<div id=\"cellDiv4\"></div><br/>\n" +
            "\t\t\t\t<div id=\"wbDiv4\"><div id='etmCellDiv4' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c4'>View Time Details</a></div></div>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"pastShifts5\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c5\" name=\"date5\" value=\"Fri 10/11\" />\n" +
            "\t\t\t\t<div id=\"cellDiv5\"></div><br/>\n" +
            "\t\t\t\t<div id=\"wbDiv5\"><div id='etmCellDiv5' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c5'>View Time Details</a></div></div>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"pastShifts6\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c6\" name=\"date6\" value=\"Sat 10/12\" />\n" +
            "\t\t\t\t<div id=\"cellDiv6\"></div><br/>\n" +
            "\t\t\t\t<div id=\"wbDiv6\"><div id='etmCellDiv6' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c6'>View Time Details</a></div></div>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\n" +
            "\n" +
            "\t\t\n" +
            "\t\t<div id=\"dayTitle2\"><h2>Current Week - 10/13/2013 to 10/19/2013</h2></div>\n" +
            "\t\t<table class=\"weekDisplay\" id=\"weekDisplay2\">\n" +
            "\t\t\t<tr id=\"calHeader2\" class=\"calHeader\">\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Sun 10/13</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Mon 10/14</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Tue 10/15</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Wed 10/16</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Thu 10/17</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Fri 10/18</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Sat 10/19</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"history\" id=\"presentShifts7\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c7\" name=\"date7\" value=\"Sun 10/13\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck7\" id=\"dayCheck7\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_7\" id=\"dayCheck2_7\" value=\"\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv7\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv7\" class=\"PastClass\">\t\n" +
            "\t\t\t\t \n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div id=\"wbDiv7\"><div id='etmCellDiv7' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c7'>View Time Details</a></div></div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"presentShifts8\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c8\" name=\"date8\" value=\"Mon 10/14\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<div id=\"currentDayMessage\"><div id='TodayClass1' class='TodayClass1'></div></div>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck8\" id=\"dayCheck8\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_8\" id=\"dayCheck2_8\" value=\"\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv8\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv8\" class=\"TodayClass\">\t\n" +
            "\t\t\t\t \t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"presentShifts9\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c9\" name=\"date9\" value=\"Tue 10/15\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck9\" id=\"dayCheck9\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_9\" id=\"dayCheck2_9\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv9\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv9\" class=\"TodayClass\">\t\n" +
            "\t\t\t\t \t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"presentShifts10\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c10\" name=\"date10\" value=\"Wed 10/16\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck10\" id=\"dayCheck10\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_10\" id=\"dayCheck2_10\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv10\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv10\" class=\"TodayClass\">\t\n" +
            "\t\t\t\t \t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >18:00-19:00</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >DCA Event Capt -  </span>\n" +
            "\t\t\t\t\t\t</div><p/>\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >19:00-00:00</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >F!View Capt -  </span>\n" +
            "\t\t\t\t\t\t</div><p/>\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"presentShifts11\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c11\" name=\"date11\" value=\"Thu 10/17\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck11\" id=\"dayCheck11\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_11\" id=\"dayCheck2_11\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv11\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv11\" class=\"TodayClass\">\t\n" +
            "\t\t\t\t \t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >15:00-23:30</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div><p/>\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"presentShifts12\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c12\" name=\"date12\" value=\"Fri 10/18\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck12\" id=\"dayCheck12\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_12\" id=\"dayCheck2_12\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv12\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv12\" class=\"TodayClass\">\t\n" +
            "\t\t\t\t \t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >13:15-19:15</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div><p/>\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"presentShifts13\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c13\" name=\"date13\" value=\"Sat 10/19\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck13\" id=\"dayCheck13\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_13\" id=\"dayCheck2_13\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv13\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv13\" class=\"TodayClass\">\t\n" +
            "\t\t\t\t \t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >14:00-22:30</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div><p/>\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\n" +
            "\n" +
            "\t\t\n" +
            "\t\t<div id=\"dayTitle3\"><h2>Next Week - 10/20/2013 to 10/26/2013</h2></div>\n" +
            "\t\t<table class=\"weekDisplay\" id=\"weekDisplay3\">\n" +
            "\t\t\t<tr id=\"calHeader3\" class=\"calHeader\">\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Sun 10/20</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Mon 10/21</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Tue 10/22</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Wed 10/23</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Thu 10/24</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Fri 10/25</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<th class=\"nowrapCell\">Sat 10/26</th>\n" +
            "\t\t\t\t\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"history\" id=\"futureShifts14\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c14\" name=\"date14\" value=\"Sun 10/20\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck14\" id=\"dayCheck14\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_14\" id=\"dayCheck2_14\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv14\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv214\">\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"availCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"availDate\" ></span>\n" +
            "\t\t\t\t\t\t  <span class=\"reason\" >RDO                                </span>\n" +
            "\t\t\t\t\t    </div>\n" +
            "\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"futureShifts15\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c15\" name=\"date15\" value=\"Mon 10/21\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck15\" id=\"dayCheck15\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_15\" id=\"dayCheck2_15\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv15\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv215\">\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >13:15-21:30</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"futureShifts16\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c16\" name=\"date16\" value=\"Tue 10/22\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck16\" id=\"dayCheck16\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_16\" id=\"dayCheck2_16\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv16\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv216\">\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >16:00-22:00</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"futureShifts17\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c17\" name=\"date17\" value=\"Wed 10/23\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck17\" id=\"dayCheck17\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_17\" id=\"dayCheck2_17\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv17\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv217\">\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >13:15-21:30</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"futureShifts18\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c18\" name=\"date18\" value=\"Thu 10/24\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck18\" id=\"dayCheck18\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_18\" id=\"dayCheck2_18\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv18\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv218\">\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >13:00-20:30</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"futureShifts19\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c19\" name=\"date19\" value=\"Fri 10/25\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck19\" id=\"dayCheck19\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_19\" id=\"dayCheck2_19\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv19\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv219\">\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"shiftCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"date\" >13:30-19:30</span>\n" +
            "\t\t\t\t\t\t  <span class=\"position\" >Racers HH -  </span>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t<td class=\"history\" id=\"futureShifts20\">\n" +
            "\t\t\t\t<input type=\"hidden\" id=\"c20\" name=\"date20\" value=\"Sat 10/26\" />\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck20\" id=\"dayCheck20\" value=\"\"/>\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"dayCheck2_20\" id=\"dayCheck2_20\" value=\"success\"/>\n" +
            "\t\t\t\t<div id=\"dayCheckDiv20\"></div>\n" +
            "\t\t\t\t<div id=\"cellDiv220\">\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<div class=\"availCellClass\">\n" +
            "\t\t\t\t\t\t  <span class=\"availDate\" ></span>\n" +
            "\t\t\t\t\t\t  <span class=\"reason\" >RDO                                </span>\n" +
            "\t\t\t\t\t    </div>\n" +
            "\t\t\t\t\t<p/>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table><br/>\n" +
            "\t\t<table id=\"navTableBottom\"><tr><td id=\"etmMessageCellBottom\"><div class=\"etmDiv\">\n" +
            "\t\t\t\t<a href='#workbrainMessage' name='modal'><strong>View My Time Details</strong></a>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t</div></td>\n" +
            "\t\t\t\t<td id=\"nextMessageCellBottom\"><div class=\"nextDiv\">\n" +
            "\t\t\t\t<strong>Next Week</strong>\n" +
            "\t\t\t\t<a href='#' onclick='doNext();' id='nextLink'><img src='/davpublish/wdpr/resources/xpressForms/images/designer/moveRight.png' alt='Move forward a week' /></a>\n" +
            "\t\t\t</div></td></tr></table>\n" +
            "\t\t\n" +
            "\t\t</div>\n" +
            "\t\t<input type=\"hidden\" name=\"publishExceeded\" value=\"\" id=\"publishExceeded\">\n" +
            "<br/>\n" +
            "<input type=\"hidden\" name=\"todayIndex\" value=\"8\" id=\"todayIndex\">\n" +
            "\t<div id=\"messageArea\"></div>\n" +
            "</form>\n" +
            "\n" +
            "\n" +
            "</td></tr>\n" +
            "<tr>\n" +
            "<td colspan=\"2\">\n" +
            "<div id=\"eligDiv\" class=\"eligDiv\">\n" +
            "    <table id=\"eligTable\" class=\"elibTable\">\n" +
            "\t\t\t<tr><td colspan=\"2\" class=\"moduleBanner\">Eligibility For PINEJ034</td></tr>\n" +
            "            <tr><td colspan=\"2\" class=\"moduleBackground\">PREVIOUS EHH USER... <br/>Verify Cast Member name ... <strong>Javier Pineda</strong><br/>Checking VISA eligibility ...DONE<br/>Checking OVERUTILIZED eligibility ...DONE<br/>Checking MINOR eligibility ...DONE<br/>Checking EHH record ...UPDATE USER</font> ... DONE<br/>DONE<br/></td></tr>\n" +
            "            \n" +
            "        \t<tr><td\tcolspan=\"2\" class=\"moduleBackground\"></td></tr>\n" +
            "        \t<tr><td colspan=\"2\">\n" +
            "    \n" +
            "    \t\t\t<br/>This user is eligible to pick up Open Shifts (EHH) and his/her restrictions have been loaded.  See messages above for further explanation.<br/>\n" +
            "                 </td>\n" +
            "            </tr>\n" +
            "    \n" +
            "\t</table></div>\n" +
            "</td></tr></table>\n" +
            "\n" +
            "\t\n" +
            "\t\t<script type=\"text/javascript\">$j('#eligDiv').show();$j('#eligTable').show();</script>\n" +
            "\t\n" +
            "\t\n" +
            "\n" +
            "<div id=\"trueBottom\"></div>\n" +
            "\n" +
            "<div style=\"display:none;\">00386186 test schedule.result= Shift:</div>\n" +
            "<form name=\"EhhForm\" id=\"searchShiftsForm\" method=\"post\" action=\"/site/dlr/template.MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet.tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252Fehh.do%253Bjsessionid%253D4DAC8D604E52939AC034C34C8F313E69&beanID=1406643234&viewID=maximized&javax.portlet.begCacheTok=com.vignette.cachetoken&javax.portlet.endCacheTok=com.vignette.cachetoken\">\n" +
            "  \t<input type=\"hidden\" name=\"method\" value=\"searchShifts\" id=\"filterMethod\">\n" +
            "\t<input type=\"hidden\" name=\"asUser\" value=\"PINEJ034\" id=\"filterUserPortal\">\n" +
            "\t<input type=\"hidden\" name=\"asPerner\" value=\"00386186\" id=\"filterUserPerner\">\n" +
            "\t<input type=\"hidden\" name=\"portalId\" value=\"PINEJ034\" id=\"originalPortal\">\n" +
            "\t<input type=\"hidden\" name=\"proxyId\" value=\"\" id=\"originalProxy\">\n" +
            "\t<input type=\"hidden\" name=\"action\" value=\"\" id=\"searchAction\">\n" +
            "\t<input type=\"hidden\" name=\"shiftId\" value=\"0\" id=\"searchShiftId\">\n" +
            "\t<input type=\"hidden\" name=\"propertyId\" value=\"0\" id=\"propertyId\">\n" +
            "\t<input type=\"hidden\" name=\"areaId\" value=\"0\" id=\"areaId\">\n" +
            "\t<input type=\"hidden\" name=\"locationId\" value=\"0\" id=\"locationId\">\n" +
            "\t<input type=\"hidden\" name=\"lobId\" value=\"0\" id=\"lobId\">\n" +
            "\t<input type=\"hidden\" name=\"startDate\" value=\"10/14/2013\" id=\"startDate\">\n" +
            "\t<input type=\"hidden\" name=\"endDate\" value=\"\" id=\"endDate\">\n" +
            "\t<br/><input type=\"button\" name=\"action\" value=\"Search\" onclick=\"doISVSearch();\" id=\"searchEhhShiftsButton\">\n" +
            "</form>\n" +
            "\n" +
            "<div id=\"workbrainMessage\"></div>\n" +
            "\t      \n" +
            "\t      \n" +
            "\t    \n" +
            "\n" +
            "    </td>\n" +
            "  </tr>\n" +
            "</table>\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t<!-- End pageContent -->\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<td width=\"213\" class=\"quickAccessPanelStyle\" valign=\"top\">\n" +
            "\t\t\t\t\t<!-- FAST Search implementation goes here  --> \n" +
            "\t\t\t\t\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- FAST SIMPLE SEARCH -->\n" +
            "<div id=\"enterpriseSearch\">\n" +
            "\t<form action=\"index.jsp?epi-content=GENERIC&beanID=1326258214&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=search_results.jsp&wsrp-windowState=wsrp:maximized\"  method=\"get\" name=\"ess_search_form\" onsubmit=\"return validateDEPSearchForm (this)\"><input type=\"hidden\" name=\"epi-content\" value=\"GENERIC\"></input><input type=\"hidden\" name=\"beanID\" value=\"1326258214\"></input><input type=\"hidden\" name=\"viewID\" value=\"maximized\"></input><input type=\"hidden\" name=\"wsrp-mode\" value=\"wsrp:view\"></input><input type=\"hidden\" name=\"wsrp-navigationalState\" value=\"search_results.jsp\"></input><input type=\"hidden\" name=\"wsrp-windowState\" value=\"wsrp:maximized\"></input><input type=\"hidden\" name=\"dep-isForm\" value=\"true\"></input>\n" +
            "\t\t<fieldset>\n" +
            "\t\t\t<input type=\"text\" name=\"ess_search_query\" value=\"\" autocomplete=\"on\"/>\n" +
            "                        \n" +
            "\t\t\t<input class=\"Button\" type=\"Submit\" value=\"Search\" />\n" +
            "\t\t</fieldset>\n" +
            "\t\t<fieldset>\n" +
            "\t\t\t<select name='ess_search_siteSelection'>  <option  value='this'>DLR only  <option selected value='all'>All sites</option>  <option  value='people'>People</option></select>\n" +
            "            \t\t\t\n" +
            "\t\t\t <label><a href=\"index.jsp?epi-content=GENERIC&beanID=1326258214&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=advanced_search.jsp&wsrp-windowState=wsrp:maximized\">Advanced Search</a></label>\n" +
            "\t\t\t\n" +
            "\t\t\t\n" +
            "\t\t\t <label><a href=\"http://enterpriseportal.disney.com/site/team/index.jsp?epi-content=RAW&epiproxymethod=get&viewID=epiproxybanner&beanID=1864233772&epiproxyrealurl=https://presto.disney.com/enterprise-it/strategic-services/strategy-policy/knowledge-management-strategy/portal-search-help.html\" target=\"_blank\">Help</a></label>\n" +
            "\t\t\t\n" +
            "            \n" +
            "\t\t</fieldset>\n" +
            "\t</form>\n" +
            "</div>\n" +
            "\n" +
            "<script>\n" +
            "\n" +
            "\t\n" +
            "function determineSearchTarget (searchForm)\n" +
            "{\n" +
            "\tvar siteSelector = searchForm.ess_search_siteSelection;\n" +
            " if (siteSelector == null) {\n" +
            "      return true;\n" +
            " }\n" +
            "\tvar i = null;\n" +
            " if (siteSelector.type != 'hidden') {\n" +
            "       i = searchForm.ess_search_siteSelection.options.selectedIndex;\n" +
            " }\n" +
            "\tif ((siteSelector.type != 'hidden') && (searchForm.ess_search_siteSelection.options [i].value=='people'))\n" +
            "\t{\n" +
            "\t\tvar queryString = searchForm.ess_search_query.value;\n" +
            "\t\tif (queryString == null || queryString == '')\n" +
            "\t\t{\n" +
            "\t\t\tif (searchForm.name == 'ess_search_results_form')\n" +
            "\t\t\t{\n" +
            "\t\t\t\tqueryString = searchForm.ess_search_prevQueryString.value;\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t\tvar contactsURL = \"https://contacts.disney.com/?stype=startw&portal=1&ssect=people&stext=\"+queryString;\n" +
            "\t\twindow.open (contactsURL, 'Contacts', '');\n" +
            "\t\treturn false;\n" +
            "\t}\n" +
            "\telse\n" +
            "\t{\n" +
            "\t\treturn true;\n" +
            "\t}\n" +
            "}\n" +
            "\n" +
            "function essTrim(str)\n" +
            "{\n" +
            "  return str.replace(/^\\s*|\\s*$/g,'');\n" +
            "}\n" +
            "\n" +
            "function essIsEmpty(str)\n" +
            "{\n" +
            "   if (str == null) return true;\n" +
            "   str = essTrim (str);\n" +
            "   if (str.length == 0) return true;\n" +
            "   return false;\n" +
            "}\n" +
            "function essStripCharacters (inStr)  \n" +
            "{  \n" +
            "\tvar stripCharacters = '#%&+-/\\\\;<>=@[]{}_`|~()^$!:.';  \n" +
            "\tvar newStr = \"\";  \n" +
            "\tfor (var i = 0; i < inStr.length; i++)  \n" +
            "\t{  \n" +
            "\t\tvar thisChar = inStr.charAt (i);  \n" +
            "\t\tif (stripCharacters.indexOf (thisChar) >= 0)  \n" +
            "\t\t{  \n" +
            "\t\t\tnewStr += ' ';  \n" +
            "\t\t}  \n" +
            "\t\telse  \n" +
            "\t\t{  \n" +
            "\t\t\tnewStr += thisChar;  \n" +
            "\t\t}  \n" +
            "\t}  \n" +
            "\treturn newStr;  \n" +
            "}\n" +
            "            \n" +
            "        \n" +
            "\n" +
            "\tfunction validateDEPSearchForm (thisForm)\n" +
            "\t{\n" +
            "\t\t//alert (\"In validateDEPSearchForm!!!\");\n" +
            "\t\t// Make sure we have some input...\n" +
            "\t\tvar queryString = thisForm.ess_search_query.value;\n" +
            "\n" +
            "\t\t// strip out all useless control characters, and\n" +
            "\t\t// put it back in the form\n" +
            "\t\tqueryString = essStripCharacters (queryString);\n" +
            "\t\tthisForm.ess_search_query.value = queryString;\n" +
            "\n" +
            "\t\t//alert (\"queryString=\"+queryString);\n" +
            "\t\tif (essIsEmpty (queryString))\n" +
            "\t\t{\n" +
            "\t\t\talert (\"Please enter a search term.\");\n" +
            "\t\t\tthisForm.ess_search_query.focus ();\n" +
            "\t\t\treturn false;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t// Determine whether we should post to \n" +
            "\t\treturn determineSearchTarget (thisForm);\n" +
            "\t}\n" +
            "\n" +
            "</script>\n" +
            "<!-- END FAST SIMPLE SEARCH -->\n" +
            "\n" +
            "\n" +
            " \n" +
            "\t\t\t\t\t<!--  End FAST Search implementation --> \n" +
            "\t\t\t\t\t\n" +
            "\n" +
            "\t\t\t\t\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- Start Module Chrome -->\n" +
            "\n" +
            "<table class='mdtQuickAcessPanel' width='213' border='0' cellspacing='0' cellpadding='0' >\n" +
            "\t<tr>\n" +
            "\t\t<td>\n" +
            "\t\t\t<table width=\"100%\" border=\"0\"  cellspacing=\"0\" cellpadding=\"0\" class=\"mdt_QAP_Banner\">\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td align=\"right\" valign=\"top\" class=\"mdt_QAP_Toolbar\" >\t\t\t\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t</td>\n" +
            "\t</tr>\n" +
            "\t\n" +
            "\t<tr class=\"mdt_QAP_Background\">\n" +
            "\t\t<td>\n" +
            "\t\t\t<table width=\"100%\" border=\"0\"  cellspacing=\"0\" cellpadding=\"0\" class=\"mdt_QAP_Gradient\" id=\"mdt_QAP_Gradient\">\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td class='mdt_QAP_View' valign='top'>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- Start Quick Access Module -->\n" +
            "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" name=\"FeatMod\">\n" +
            "  <tr>\n" +
            "    <td align=\"left\" valign=\"top\">\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "</td></tr><tr><td>\n" +
            "</td></tr><tr><td>\n" +
            "</td></tr><tr><td>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- Start rostr module -->\n" +
            "<div id=\"rostr_widget\">\n" +
            "\t<script src=\"https://rostr.disney.com/widget/search/search.nocache.js\" type=\"text/javascript\"></script>\n" +
            "\t<div id=\"rostr_search_widget\"> </div>\n" +
            "\t<p class=\"rostr_contacts_link\">\n" +
            "\t\t<a target=\"_new\" href=\"https://contacts.disney.com\">CONTACTS</a>\n" +
            "\t</p>\n" +
            "</div>\n" +
            "<!-- end rostr module --></td></tr><tr><td>\n" +
            "</td></tr><tr><td>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- Start Module Chrome -->\n" +
            "<table class='mdt_quickAccessModule' width='100%' border='0' cellspacing='0' cellpadding='0' align='CENTER'>\n" +
            "\n" +
            "\t\t<tr>\n" +
            "\t\t\t<td>\n" +
            "\t\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" class=\"mdt_QAP_moduleHeaderQuickLinks\">\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t<!-- Display the Welcome user line -->\n" +
            "\t\t\t<td nowrap class=\"mdt_QAP_moduleBanner\"><img src=\"/gopublish/sitemedia/Image/icn-quicklinks.gif\" align=\"TOP\" alt=\"\">&nbsp;Quick Links</td>\n" +
            "\t\t\t<td nowrap class=\"mdt_QAP_moduleToolbar\">&nbsp;\n" +
            "\t\t\t\t<a href=\"/site/dlr/index.jsp?epi-content=GENERIC&viewID=USER_BEAN_EDIT_VIEW&beanID=122819324\"><img src=\"/templates/ZaXbRfRQXTdVZYUSbWXaYRRVVUSXWQZZ/UacaTfbTQaVdUefXVcSWdTdQVUSXWQZZ/module_edit_sm.gif\" alt=\"customize this module\" border=\"0\" WIDTH=\"27\" HEIGHT=\"12\"></a>\n" +
            "\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t\t</td>\n" +
            "\t\t</tr>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<td valign=\"top\" class=\"mdt_QAP_moduleView\">\n" +
            "\n" +
            "\n" +
            "<epi_html:controllerURL />\n" +
            "\n" +
            "<!-- Start Quick Links Module -->\n" +
            "\n" +
            "<script language=\"javascript\">\n" +
            "\n" +
            "\tfunction qlOpenWindow( url, type )\n" +
            "\t{\n" +
            "\t\twindow.name     = \"portal_root\";\n" +
            "\t\twindow.rootopen = \"true\";\n" +
            "\t\tw               = window.open(url, type, \"toolbar=no,  location=no, directories=no, status=yes, menubar=yes, scrollbars=yes, resizable=yes, left=0, top=0\");\n" +
            "\t\twindow.setTimeout('w.focus()',100);\n" +
            "\t\treturn;\n" +
            "\t}\n" +
            "\n" +
            "\tfunction qlOpenWindow2( url, type )\n" +
            "\t{\n" +
            "\t\twindow.name     = \"portal_root\";\n" +
            "\t\twindow.rootopen = \"true\";\n" +
            "\t\tw2              = window.open(url, type, \"toolbar=yes, location=no, directories=no, status=yes, menubar=yes, scrollbars=yes, resizable=yes, left=0, top=0\");\n" +
            "\t\twindow.setTimeout('w2.focus()',100);\n" +
            "\t\treturn;\n" +
            "\t}\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "<div id=\"quicklinks_module\">\n" +
            "<!-- current profile\n" +
            "\t\tuser id:    1568370\n" +
            "\t\tuser login: PINEJ034\n" +
            "\t\tuser email: PINEJ034\n" +
            "\t\tuser name:  Javier Pineda\n" +
            "\t-->\n" +
            "\t\t<div class=\"teamLinks\">\n" +
            "\t\t<div class=\"quickLinkHeading\">TEAM Links</div>\n" +
            "\t\t<small>\n" +
            "\t\t<ul>\n" +
            "\t\t\n" +
            "\t\t\t\t<li><a href=\"https://efs.disney.com:9031/idp/startSSO.ping?PartnerSpId=urn:sp:fidelity:geninbndnbparts20&TargetResource=https%3A%2F%2Fdisney.fidelity.com%2Fftgw%2Fewcd%2Fhome\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Add It Up! Online';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Add It Up! Online</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"https://enterpriseportal.disney.com/site/wdw/index.jsp?epi-content=GENERIC&beanID=44256032&viewID=MY_PORTAL_VIEW&button=QuickLink_ComplimentaryAdmission\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Complimentary Admission';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Complimentary Admission</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/team/menuitem.2b652f691366c6d0a7e7f992faac01ca/index.jsp?epi-content=GENERIC&beanID=2046049605&viewID=MY_PORTAL_VIEW&button=QuickLink_DisneyIT\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disney I.T.';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disney I.T.</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/team/template.MAXIMIZE/menuitem.8bacaaa748106daf4727f59354276099/?javax.portlet.tpst=7798cd3fc3c482eb06ba6327b7653a33_ws_MX&javax.portlet.prp_7798cd3fc3c482eb06ba6327b7653a33_viewID=safeharborchk_process&app=elp&button=QuickLink_DevelopmentConnection\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Development Connection';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Development Connection</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"index.jsp?epi-content=GENERIC&viewID=MY_PORTAL_VIEW&beanID=683161281&button=QuickLink_DisneyInventors\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disney Inventors';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disney Inventors</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.sap.pct.erp.ess.wda.bp_folder/com.sap.pct.erp.ess.wda.iviews/com.sap.pct.erp.ess.wda.overview_external\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Employee Services';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Employee Services</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_PERSINFO&WebDynproConfiguration=HRESS_AC_PERSINFO&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Paycard/Direct Deposit';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Paycard/Direct Deposit</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/gopublish/sitemedia/TDO/HR/EmpPolicies_index.html\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Employee Policies';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Employee Policies</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_CATS_1&WebDynproConfiguration=HRESS_AC_CATS_1&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Enter My Time (SAP)';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Enter My Time (SAP)</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/team/menuitem.2b652f691366c6d0a7e7f992faac01ca/index.jsp?epi-content=GENERIC&viewID=MY_PORTAL_VIEW&beanID=913246064&button=QuickLink_GlobalSecurity\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Global Security';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Global Security</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/gopublish/sitemedia/TDO/HR/Talent_Acquisition/MyDisneyCareer/index.html\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: My Disney Career';return true;\" onMouseOut=\"javascript:top.status='';return true;\">My Disney Career</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"https://enterpriseportal.disney.com/site/team/index.jsp?epi_menuItemID=2b652f691366c6d0a7e7f992faac01ca&epi_menuID=9bbbfcf8ee100b7f4727f59354276099&epi_baseMenuID=9bbbfcf8ee100b7f4727f59354276099&DEPTaxonomyNode-8963840233b17e88177a8115f9ac01ca=6522&button=QuickLink_PerformanceConnection\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Performance Connection';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Performance Connection</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/wdw/index.jsp?epi-content=GENERIC&beanID=1876682105&viewID=MY_PORTAL_VIEW&button=QuickLink_SAPHelp\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: SAP Help';return true;\" onMouseOut=\"javascript:top.status='';return true;\">SAP Help</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mypersonal.swna.wdpr.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.twdc.fl.express/com.twdc.fl.roles/com.twdc.rl.express\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Portal Express';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Portal Express</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mypersonal.swna.wdpr.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.TWDC.fl.PUN/com.TWDC.fl.PUNRoles/com.TWDC.rl.sap_work_place\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: SAP Work Place';return true;\" onMouseOut=\"javascript:top.status='';return true;\">SAP Work Place</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/team/index.jsp?epi-content=GENERIC&beanID=1084606812&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=ViewID%3DArticleDetail%26ContentID%3D570168&wsrp-windowState=wsrp:maximized&button=QuickLink_StandardsofBusinessConductTranslated\" target=\"_top\" title=\"Standards of Business Conduct\" onMouseOver=\"javascript:top.status='Quick Link: Standards of Business Conduct';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Standards of Business...</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"https://efs.disney.com:9031/idp/startSSO.ping?PartnerSpId=augustus.iqnavigator.com\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Temp Staffing/Zerochaos';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Temp Staffing/Zerochaos</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"javascript:void(window.open('http://mypersonal.swna.wdpr.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.TWDC.fl.ESS/com.TWDC.fl.time_and_pay/com.TWDC.fl.taxes/com.TWDC.fl.taxes_pages/com.TWDC.pg.view_w-2','SAP','menubar,status,scrollbars,resizable'))\n" +
            "\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: W2 Online/Multi St. Policy';return true;\" onMouseOut=\"javascript:top.status='';return true;\">W2 Online/Multi St. Policy</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_PAYSLIP&WebDynproConfiguration=ZHRESS_AC_PAYSLIP&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: View Paystub Online';return true;\" onMouseOut=\"javascript:top.status='';return true;\">View Paystub Online</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/team/menuitem.b1b4d4b7e046c366694b2f13f9ac01ca/index.jsp?epi-content=GENERIC&dsfnavstate=%252FPayroll_Services%252FPayrollServices_index.jsp&beanID=1333946875&viewID=maximized&button=QuickLink_PayrollServices_External\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Payroll Services';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Payroll Services</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_PTARQ_TIMEACC&WebDynproConfiguration=HRESS_AC_PTARQ_TIMEACC&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: View Available Time Off';return true;\" onMouseOut=\"javascript:top.status='';return true;\">View Available Time Off</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"https://enterpriseportal.disney.com/site/team/index.jsp?epi-content=GENERIC&beanID=1084606812&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=ViewID%3DArticleDetail%26ContentID%3D608868&wsrp-windowState=wsrp:maximized&button=QuickLink_YourDiscounts\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Your Discounts';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Your Discounts</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/team/template.MAXIMIZE/menuitem.c88bc58a6af5447ab8588a1608e26099/?javax.portlet.tpst=e7c8eebe56621663519de110f7e26099_ws_MX&javax.portlet.prp_e7c8eebe56621663519de110f7e26099_viewID=maximized&beanID=446623392&viewID=maximized&javax.portlet.begCacheTok=com.vignette.cachetoken&javax.portlet.endCacheTok=com.vignette.cachetoken&javax.portlet.prp_e7c8eebe56621663519de110f7e26099_dsfnavstate=%252Fdsfpublishing%252Fteam%252Fhr%252Fenterprise_engagement_survey%252Findex.html\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Employee Survey 2012';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Employee Survey 2012</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/wdpr/index.jsp/?epi-content=GENERIC&beanID=1916562460&viewID=MY_PORTAL_VIEW&button=QuickLink_WDPRLeadership\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: WDPR Leadership';return true;\" onMouseOut=\"javascript:top.status='';return true;\">WDPR Leadership</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"javascript:void(window.open('https://mypersonal.disney.com/r3webdynpro/dispatcher/twdc.com/r3~hr~m18rec/RecCardApp','SAP','menubar,status,scrollbars,resizable'))\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: View Record Card';return true;\" onMouseOut=\"javascript:top.status='';return true;\">View Record Card</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://centerstage.nena.wdpr.disney.com\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: CenterStage';return true;\" onMouseOut=\"javascript:top.status='';return true;\">CenterStage</a></li>\n" +
            "\t\t\t\n" +
            "\t\t</ul></small></div>\n" +
            "\t\t\n" +
            "\t\t<a class=\"addThisPage\" target=\"_top\" href=\"/site/dlr/index.jsp?epi-content=GENERIC&beanID=122819324&viewID=add_this_link\">&lt;- Add This Page</a>\n" +
            "\t\t\n" +
            "\t\t<div class=\"quickLinks\">\n" +
            "\t\t<div class=\"quickLinkHeading myLinks\">My Links</div>\n" +
            "\t\t<!-- ol style=\"margin:0;padding:0;list-style-position:inside;color:#666666\" -->\n" +
            "\t\t<small><ul>\n" +
            "\t\t\t\t<li><a href=\"https://enterpriseportal.disney.com/site/dlr/menuitem.427e06f258729e615927f59354276099/&\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Work Schedule';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Work Schedule</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/wdw_generic.jsp?textID=depotwsrpconsumer134_DLRCastLink&viewID=MY_PORTAL_VIEW\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Cast Link';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Cast Link</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/index.jsp?epi-content=GENERIC&beanID=965211087&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=contentId%3D124505%26xslFile%3Dwdw_policy.xsl%26expDepth%3D2%26xslLoc%3Dcommon&wsrp-windowState=wsrp:maximized&displayname=WDP%26R+Print+Publications\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disneyland Resort Line';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disneyland Resort Line</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://enterpriseportal.disney.com/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/index.jsp?epi-content=GENERIC&beanID=965211087&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=contentId%3D599301%26xslFile%3Dwdw_article.xsl%26expDepth%3D2%26xslLoc%3Dcommon&wsrp-windowState=wsrp:maximized&displayname=WDPR+Video%3Cbr%3E%3Cbr%3E\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: CAST TV';return true;\" onMouseOut=\"javascript:top.status='';return true;\">CAST TV</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://dlr-cds.wdw.disney.com\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: DLR-CDS';return true;\" onMouseOut=\"javascript:top.status='';return true;\">DLR-CDS</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"https://enterpriseportal.disney.com/site/dlr/index.jsp?epi-content=GENERIC&beanID=1885976808&viewID=MY_PORTAL_VIEW&\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Labor Tool Box';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Labor Tool Box</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://dm-caan-ww001/webeditor\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: DLR SmarTeam-Animal';return true;\" onMouseOut=\"javascript:top.status='';return true;\">DLR SmarTeam-Animal</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"https://burbank-backstagepass.disney.com\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Backstage Pass - Burbank';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Backstage Pass - Burbank</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://disneycontacts.corp.disney.com/disneycontacts.asp\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: DLR Phone Directory';return true;\" onMouseOut=\"javascript:top.status='';return true;\">DLR Phone Directory</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/site/dlr/index.jsp?epi-content=GENERIC&beanID=351283989&viewID=MY_PORTAL_VIEW&\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Cast Dining';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Cast Dining</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://fl.wdi.disney.com/trivia/\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: WDI Trivia Net';return true;\" onMouseOut=\"javascript:top.status='';return true;\">WDI Trivia Net</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/dlr/index.jsp?epi-content=GENERIC&viewID=MY_PORTAL_VIEW&beanID=1872953236\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Commuter Assistance';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Commuter Assistance</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"/davpublish/tpr/publications/disneydesktops/index.html\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disney Desktops';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disney Desktops</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://maxappprd.wdw.disney.com/AutomatedDispatch_Web/OrderForm.aspx?width=1280\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: MAD';return true;\" onMouseOut=\"javascript:top.status='';return true;\">MAD</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://mxesprd.wdw.disney.com/maximo\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Maximo';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Maximo</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://sena-webapps.wdw.disney.com/LostFound-DLR/login.aspx\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Lost & Found - DLR';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Lost & Found - DLR</a></li>\n" +
            "\t\t\t\n" +
            "\t\t\t\t<li><a href=\"http://swna-webapps.swna.wdpr.disney.com/lostfound/login.aspx\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Lost & Found - WDPR';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Lost & Found - WDPR</a></li>\n" +
            "\t\t\t</ul></small></div>\n" +
            "</div>\n" +
            "<!-- End Quick Links Module -->\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\n" +
            "\t</table>\n" +
            "\n" +
            "<!-- End Module Chrome -->\n" +
            "</td></tr><tr><td>\n" +
            "</td></tr><tr><td>\n" +
            "\n" +
            "    </td>\n" +
            "  </tr>\n" +
            "</table>\n" +
            "<!-- End Quick Access Module -->\n" +
            "\t\t\t\t\t</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</table>\n" +
            "\t\t</td>\n" +
            "\t</tr>\n" +
            "\n" +
            "\t<tr>\n" +
            "\t\t<td class=\"mdt_QAP_Footer\">\n" +
            "\t\t</td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "<!-- End Module Chrome -->\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!--\n" +
            "############################################################\n" +
            "# START: Quick Access Page Control\n" +
            "############################################################\n" +
            " -->\n" +
            "\n" +
            "<!--\n" +
            "############################################################\n" +
            "# END: Quick Access Page Control\n" +
            "############################################################\n" +
            " -->\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t\n" +
            "\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\t\t<table class=\"grid\" id=\"pageFooter\" description=\"This table is for page layout.\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"2\">\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"footerStyle\" valign=\"bottom\" height=\"1\">\n" +
            "\t\t\t\t\t\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!-- DLR -->\n" +
            "\n" +
            "\n" +
            "<div id=\"footer_main\">    \n" +
            "\n" +
            "\t\n" +
            "\n" +
            "\t<div class=\"moduleSubBanner\">\t</div>\n" +
            "\n" +
            "\t<div id=\"footer_copyright1\"> \n" +
            "\t\t<br> (c) Disney<br>\n" +
            "\t</div> \n" +
            "\n" +
            "\t<div id=\"footer_toplinks\">\n" +
            "\t\n" +
            "\t\n" +
            "\t\n" +
            "\n" +
            "\t\t <a href=\"index.jsp?epi-content=ADD_CONTENT\">\n" +
            "\t\t \tAdd a Module</a>\n" +
            "         &nbsp;|&nbsp;\n" +
            "\n" +
            "\t\t<!--  <a href=\"javascript:window.print()\">Print This Page</a>  \n" +
            "         &nbsp;|&nbsp; -->\n" +
            "         <a href=\"index.jsp?epi-content=GENERIC&beanID=226&viewID=resetform\">\n" +
            "         \tContact Us</a>\n" +
            "\t         <!-- <a href=\"https://backlot.disney.com/community/waltdisneyparksandresorts/thehub\">The Hub Help and Feedback</a> \n" +
            "    \t     This was required by Comm. Tech at July 2012, but they did not get back to us to push it to PROD,\n" +
            "        \t we need to update this file and push to PROD with changes for Cast Tab, this is the reason this is being commented -->\n" +
            "          &nbsp;|&nbsp;\n" +
            "\t\t  \n" +
            "         <a href=\"/site/wdw/index.jsp?epi-content=GENERIC&beanID=901610026&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=%2FHub_Request_Center_Service%2Fgeneral%2Findex.do%3Fmethod%3Dhistory&wsrp-windowState=wsrp:maximized\">\n" +
            "\t\t\tThe Hub Request Center</a>\n" +
            "         \n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t</div>\t\n" +
            "\n" +
            "\t\n" +
            "\n" +
            "\t<div id=\"footer_bottomlinks\">\t\n" +
            "\t\t<br>\n" +
            "\t\t<a href='/site/dlr/menuitem.0fe1b04e6678832db78936f0faac01ca/&DEPTaxonomyNode-b9a939a7a9c3e616c53f1776faac01ca=570'>\n" +
            "\t\t\tHome</a>\n" +
            "\t\t&nbsp;|&nbsp;\n" +
            "\t\t<a href='/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/&'>\n" +
            "\t\t\tDisneyland Resort</a>\n" +
            "\n" +
            "\t\t\n" +
            "\n" +
            "\t\t\t\t&nbsp;|&nbsp;\n" +
            "\t\t\t\t<a href='/site/dlr/menuitem.427e06f258729e615927f59354276099/&'> <!-- Registered user -->\n" +
            "\t\t\t\t\tWork</a>\n" +
            "\t\t\t\n" +
            "\t\t\t\t&nbsp;|&nbsp;\n" +
            "\t\t\t\t<a href='/site/dlr/menuitem.7d9d49e64fc2cae0c9d358250aac01ca/&'>\n" +
            "\t\t\t\t\tPersonal</a>\n" +
            "\n" +
            "\t\t\t\n" +
            "\n" +
            "\t\t&nbsp;|&nbsp;\n" +
            "\t\t<a href='/site/onesourcedlr/menuitem.34d89a4394ad66884f9ce51077e26099/&'>\n" +
            "\t\t\tGuest</a>\n" +
            "\t\t&nbsp;|&nbsp;\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t\t\t\t<a href='/site/dlr/menuitem.682fd220d3b173055d3522870bac01ca/&'> <!-- Registered user -->\n" +
            "\t\t\t\t\tCast</a>\t\n" +
            "\t\t\t\t\t\t\t\n" +
            "\n" +
            "\t</div>\n" +
            "\n" +
            "\t\n" +
            "\n" +
            "</div> \n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\t\t<!-- End Grid Table -->\n" +
            "\t</body>\n" +
            "</html>\n" +
            "<script language=\"JavaScript\">\n" +
            "var s_account=\"digintranetglobal\"\n" +
            "</script>\n" +
            "<script language=\"JavaScript\" src=\"/js/omniture/s_code.js\"></script>\n" +
            "<script language=\"JavaScript\">\n" +
            "     s.pageName=\"\"\n" +
            "     s.server=\"\"\n" +
            "     s.channel=\"\"\n" +
            "     s.pageType=\"\"\n" +
            "     s.prop1=\"\"\n" +
            "     s.prop21=\"Integrated Schedule View\"\n" +
            "     s.prop22=\"\"\n" +
            "     s.prop23=\"\"\n" +
            "     s.prop24=\"\"\n" +
            "     s.prop2=\"C\"\n" +
            "     s.prop3=\"PINEJ034\"\n" +
            "     s.prop4=\"101\"\n" +
            "     s.prop5=\"0113\"\n" +
            "     s.prop6=\"Hourly\"\n" +
            "     s.prop27=\"Anaheim\"\n" +
            "     s.prop28=\"US\"\n" +
            "     s.prop14=\"CA\"\n" +
            "\n" +
            "     s.campaign=\"\"\n" +
            "     s.state=\"\"\n" +
            "     s.zip=\"\"\n" +
            "     s.events=\"\"\n" +
            "     s.products=\"\"\n" +
            "     s.purchaseID=\"\"\n" +
            "     s.eVar1=\"\"\n" +
            "     s.eVar2=\"\"\n" +
            "     s.eVar3=\"\"\n" +
            "     s.eVar4=\"\"\n" +
            "     s.eVar5=\"\"\n" +
            "     /************* DO NOT ALTER ANYTHING BELOW THIS LINE ! **************/\n" +
            "     var s_code=s.t();if(s_code)document.write(s_code)\n" +
            "</script>\n" +
            "<!-- Total Page Elapsed Time=1743 server=cl-flor-apvm033_inst-06_dlr_6080 webserver=cl-flor-apvm109" +
            ".disney.pvt -->\n";

    static String tempHtml2 = "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- Epicentric Foundation Server -->\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<html>\r\n" +
            "<head>\r\n" +
            "\r\n" +
            "\r\n" +
            "		<title>Integrated Schedule View</title>\r\n" +
            "\r\n" +
            "<!-- GLOBAL STYLESHEET -->\r\n" +
            "	<link rel=\"stylesheet\" href=\"/css/ppf/team/newteam_common.css\" type=\"text/css\" />\r\n" +
            "<!-- MAIN IMPORT -->\r\n" +
            "	<link rel=\"stylesheet\" href=\"/davpublish/wdpr/portal_styles/css/WDPR_main.css\" type=\"text/css\" />	\r\n" +
            "<!-- PRINT STYLESHEET -->\r\n" +
            "	<link rel=\"stylesheet\" type=\"text/css\" href=\"/davpublish/wdpr/portal_styles/css/WDPR_print.css\" media=\"print\" />\r\n" +
            "	\r\n" +
            "	<base target=\"_top\">\r\n" +
            "\r\n" +
            "<!-- CODE FROM CORPORATE TO MAKE THE MOVIE AND SLIDESHOW WORK ON THE HOME TAB -->\r\n" +
            "<script type=\"text/javascript\" src=\"/js/mdt/flashobject.js\"></script>\r\n" +
            "\r\n" +
            "<!-- CODE TO ACTIVATE FLASH OBJECTS -->\r\n" +
            "<script src=\"/davpublish/wdpr/portal_styles/scripts/AC_RunActiveContent.js\" type=\"text/javascript\" ></script>\r\n" +
            "\r\n" +
            "<!-- CODE TO SUPPORT FLASH LOGIN BADGE -->\r\n" +
            "<script src=\"/davpublish/wdpr/portal_styles/scripts/badgeSupport.js\" type=\"text/javascript\" ></script>\r\n" +
            "\r\n" +
            "\r\n" +
            "</head>\r\n" +
            "\r\n" +
            "	<body style=\"font-size:70%;\" topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\r\n" +
            "	\r\n" +
            "		\r\n" +
            "		<!-- Start Grid Table -->\r\n" +
            "		\r\n" +
            "		<table class=\"grid\" id=\"pageHeader\" border=\"0\" description=\"This table is for page layout - header\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"124\">\r\n" +
            "			<tr>\r\n" +
            "				<td class=\"headerStyle\" >\r\n" +
            "				\r\n" +
            "					\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- In DEP Header Style Type header file -->\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- End of DEP Header Style Type header file -->\r\n" +
            "\r\n" +
            "\r\n" +
            "<!--\r\n" +
            "This script monitors the close action on IE browser and ask the user for logoff confirmation. Shant\r\n" +
            "-->\r\n" +
            "<script src='/js/logoff_monitor/logoff.js'></script>\r\n" +
            "\r\n" +
            "\r\n" +
            "	\r\n" +
            "		\r\n" +
            "\r\n" +
            "	\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!--  servletpath -->\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "			\r\n" +
            "        <!-- GGonzalez 8/15/2011 - JQuery Upgrade  -->\r\n" +
            "        <!-- GGonzalez 10/24/2011 - Badge / Admin Access Fix  -->\r\n" +
            "        <!--  SVasilko 11/2/2011 - Fixing Flip link -->\r\n" +
            "        <!-- SVasilko 12/2011 - bug fix for stray /site in header  -->\r\n" +
            "        \r\n" +
            "        <!--[if IE 6]>\r\n" +
            "			<link rel=\"stylesheet\" stype=\"text/css\" href=\"/davpublish/wdpr/portal_styles/css/badge_ie6.css\" />\r\n" +
            "		<![endif]-->\r\n" +
            "		<script src=\"/davpublish/wdpr/resources/jquery/jquery-1.6.1.min.js\" type=\"text/javascript\"></script>\r\n" +
            "		<script type=\"text/javascript\">           \r\n" +
            "		<!--          \r\n" +
            "		$(document).ready(\r\n" +
            "				function(){            \r\n" +
            "	            	$(\".slidingDiv\").show();\r\n" +
            "	                $(\".slidingDiv2\").hide();\r\n" +
            "		                            \r\n" +
            "		            });    \r\n" +
            "		            function flip1() { \r\n" +
            "		                    $(\".slidingDiv\").slideToggle('slow');\r\n" +
            "		                    $(\".slidingDiv2\").hide();\r\n" +
            "		                    $(\".slidingDiv\").show();\r\n" +
            "		            } \r\n" +
            "		            function flip2() { \r\n" +
            "		                    $(\".slidingDiv2\").slideToggle('slow');\r\n" +
            "		                    $(\".slidingDiv\").hide();\r\n" +
            "		                    $(\".slidingDiv2\").show();\r\n" +
            "		            }\r\n" +
            "						\r\n" +
            "		            function isNull(check){\r\n" +
            "		            	var nNull = false\r\n" +
            "		            	if(check == 'null'){ nNull = true;}\r\n" +
            "		            	if(check == null){ nNull = true;}\r\n" +
            "		            	if(check == ''){ nNull = true;}\r\n" +
            "		            	return nNull\r\n" +
            "		            }\r\n" +
            "		            function help_openWindow( moduleId, height, width ) {\r\n" +
            "		            	var linkz = \"/beans/common/help/jsp/process_helpview.jsp?beanID=tdo\";\r\n" +
            "		            	linkz     = linkz + \"&defaultId=1043\";\r\n" +
            "		            	linkz     = linkz + \"&moduleId=\"  + moduleId;\r\n" +
            "		            	if (isNull(height)) { height = \"400\"; }\r\n" +
            "		            	if (isNull(width)) { width  = \"400\"; }\r\n" +
            "		            	var windz = \"\";\r\n" +
            "		            	windz = windz + \"height=\"  + height;\r\n" +
            "		            	windz = windz + \",width=\"  + width;\r\n" +
            "		            	windz = windz + \",toolbar=no,resizable=yes,status=no,location=no,scrollbars=yes\";\r\n" +
            "		            	window.open(linkz, 'help', windz);\r\n" +
            "		            }\r\n" +
            "		        \r\n" +
            "		\r\n" +
            "		function help_openWindow( moduleId, height, width )\r\n" +
            "		{\r\n" +
            "			var linkz = \"/beans/common/help/jsp/process_helpview.jsp?beanID=tdo\";\r\n" +
            "			linkz     = linkz + \"&defaultId=\" + \"1043\";\r\n" +
            "			linkz     = linkz + \"&moduleId=\"  + moduleId;\r\n" +
            "		\r\n" +
            "			var windz = \"\";\r\n" +
            "			windz = windz + \"height=\"  + height;\r\n" +
            "			windz = windz + \",width=\"  + width;\r\n" +
            "			windz = windz + \",toolbar=no,resizable=yes,status=no,location=no,scrollbars=yes\";\r\n" +
            "		\r\n" +
            "			window.open(linkz, 'help', windz);\r\n" +
            "		}\r\n" +
            "		-->\r\n" +
            "		</script>\r\n" +
            "<!-- Start Header Table -->\r\n" +
            "\r\n" +
            "<input type=\"hidden\" id=\"site\" value=\"dlr\" />\r\n" +
            "<!-- This file should not call dynamic banners  -->\r\n" +
            "\r\n" +
            "<table description=\"This table is for 12HUB_WDPR_header layout.\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\r\n" +
            "	<tr style=\"height:105px;\">\r\n" +
            "		<td style=\"height:105px;\">\r\n" +
            "		<div id=\"dlrBanner\"></div>	\r\n" +
            "		\r\n" +
            "		<div id=\"Badge\" class=\"Badge\"> \r\n" +
            "			\r\n" +
            "			\r\n" +
            "			<div id=\"authInfo\" class=\"slidingDiv\">\r\n" +
            "				<div class=\"myI\"><a href=\"#\" onclick=\"flip2();\"><img src=\"/davpublish/wdpr/resources/common/badge/myI.png\"></a></div>\r\n" +
            "				<h1>Welcome, Javier</h1>\r\n" +
            "				<ul>\r\n" +
            "					<li><a href=\"/site/dlr/index.jsp?epi-content=SIGNOUT\" id=\"signoutLink\" title=\"Sign Out of the Hub\">Sign Out</a></li>\r\n" +
            "					<li><a href=\"/site/dlr/index.jsp?epi-content=CHANGE_PASSWORD\" id=\"changepassLink\" title=\"Change Your Password\">Change Password</a></li>\r\n" +
            "					<li><a href=\"/site/dlr/index.jsp?epi-content=LANGUAGE\" id=\"changelangLink\" title=\"Change Your Default Language\">Change Language</a></li>\r\n" +
            "					<li><a href=\"/site/dlr/index.jsp?epi-content=ADD_CONTENT\" id=\"addmodLink\" title=\"Add a module to this tab\">Add Module</a></li>\r\n" +
            "				</ul>\r\n" +
            "				<ul class=\"login\">\r\n" +
            "					<li><a href=\"#\" onclick=\"help_openWindow('1043',350,600);\" id=\"help2Link\" title=\"Help\">Help</a></li>\r\n" +
            "					<li><a href=\"/site/dlr/index.jsp?epi-content=GENERIC&beanID=226&viewID=resetform&displayname=Feedback_Form\" id=\"contactLink\" title=\"Contact Us\">Contact Us</a></li>\r\n" +
            "\r\n" +
            "					\r\n" +
            "				</ul>				\r\n" +
            "				\r\n" +
            "			</div>\r\n" +
            "			<div id=\"userBadgeData\" class=\"slidingDiv2\">\r\n" +
            "				<div class=\"myI\"><a href=\"#\" onclick=\"flip1();\"><img src=\"/davpublish/wdpr/resources/common/badge/myI_2.png\"></a></div>\r\n" +
            "				<h1>Welcome, Javier</h1>\r\n" +
            "			\r\n" +
            "				<ul>\r\n" +
            "					<li title=\"Personnel Number\">Pernr: 00386186&nbsp;</li>\r\n" +
            "					<li title=\"Personnel Area\">PA# 0113&nbsp;</li>\r\n" +
            "					<li title=\"Business Area\">Business Area: 101&nbsp;</li>\r\n" +
            "					<li title=\"Organizational Unit\">Org Unit: 10001021&nbsp;</li>\r\n" +
            "					<li title=\"Cost Center\">Cost Center: 0005100679&nbsp;</li>\r\n" +
            "				</ul>\r\n" +
            "			\r\n" +
            "			</div>\r\n" +
            "			\r\n" +
            "		</div><!-- END BADGE -->\r\n" +
            "		</td>\r\n" +
            "	</tr>\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "					\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "					<!-- Begin Horizontal Navigation Area -->\r\n" +
            "					<tr>\r\n" +
            "						<td valign=\"bottom\"  align=\"left\" colspan=\"2\">\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "								<!-- Tabs - begins -->\r\n" +
            "								<table class=\"tabs\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n" +
            "									<tr>\r\n" +
            "\r\n" +
            "						<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/&' title='Disneyland Resort'>Disneyland Resort</a></td>\r\n" +
            "\r\n" +
            "					<td valign='middle' class='TabOn' style='background:url(/images/wdw/theHub/dk_blue_tab.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.427e06f258729e615927f59354276099/&' title='Work'>Work</a></td>\r\n" +
            "\r\n" +
            "						<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.7d9d49e64fc2cae0c9d358250aac01ca/&' title='Personal'>Personal</a></td>\r\n" +
            "\r\n" +
            "						<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/onesourcedlr/menuitem.34d89a4394ad66884f9ce51077e26099/&' title='Guest'>Guest</a></td>\r\n" +
            "\r\n" +
            "						<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/dlr/menuitem.682fd220d3b173055d3522870bac01ca/&' title='Cast'>Cast</a></td>\r\n" +
            "\r\n" +
            "						<td valign='middle' class='TabOff' style='background:url(/images/wdw/theHub/tabOff.gif);background-position: top right;padding: 3px 16px 3px 6px;'><a href='/site/team/menuitem.c88bc58a6af5447ab8588a1608e26099/?' title='TWDC'>TWDC</a></td>\r\n" +
            "\r\n" +
            "									</tr>\r\n" +
            "									<tr>\r\n" +
            "									<!-- Colspan needs to match number of tabs-->\r\n" +
            "										<td colspan=6 id=\"secondNav\">\r\n" +
            "											<a href=\"/site/wdpr/?epi_menuItemID=d456d249f4e117c8382393a6faac01ca&epi_menuID=2f6704979bb06b9870d35825faac01ca&epi_baseMenuID=2f6704979bb06b9870d35825faac01ca&\" style=\"color:white;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;  text-decoration: none;text-transform: capitalize;\">\r\n" +
            "		Walt Disney Parks and Resorts</a> | \r\n" +
            "											\r\n" +
            "											Disneyland Resort | \r\n" +
            "											\r\n" +
            "											<a href=\"/site/wdw/?epi_menuItemID=6fe1735dccd1b42a677a0f05f9ac01ca&epi_menuID=eebc48d7208955615727f59354276099&epi_baseMenuID=eebc48d7208955615727f59354276099&\" style=\"color:white;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;  text-decoration: none;text-transform: capitalize;\">\r\n" +
            "													Walt Disney World</a> | \r\n" +
            "																						\r\n" +
            "											<a href=\"/site/wdi/?epi_menuItemID=324987cb21a72466b701ca150aac01ca&epi_menuID=9c8cc5318a206726547a0f05f9ac01ca&epi_baseMenuID=9c8cc5318a206726547a0f05f9ac01ca&\" style=\"color:white;font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;  text-decoration: none;text-transform: capitalize;\">\r\n" +
            "													Imagineering</a><br>\r\n" +
            "	\r\n" +
            "										</td>\r\n" +
            "									</tr>\r\n" +
            "								</table>\r\n" +
            "								<!-- Tabs - ends -->\r\n" +
            "\r\n" +
            "	\r\n" +
            "\r\n" +
            "							</td>\r\n" +
            "						</tr>\r\n" +
            "						<!-- horizontal navigation - ends -->\r\n" +
            "					</table>\r\n" +
            "					<!-- end header table -->\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "				</td>\r\n" +
            "			</tr>\r\n" +
            "		</table>\r\n" +
            "		\r\n" +
            "		\r\n" +
            "\r\n" +
            "		<table class=\"grid\" id=\"pageContent\" description=\"This table is for page layout.\" cellpadding=\"0\" cellspacing=\"0\">\r\n" +
            "			<tr>\r\n" +
            "				<td valign=\"top\" class=\"pageContent\" >\r\n" +
            "					\r\n" +
            "					<!-- Begin pageContent -->\r\n" +
            "					\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n" +
            "  <tr>\r\n" +
            "    <td width=\"100%\">\r\n" +
            "	  \r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- this is where page controls are normally inserted, -->\r\n" +
            "<!-- but page controls have been moved into the site    -->\r\n" +
            "<!-- controls style in the Quick Access Panel.          -->\r\n" +
            "	</td>\r\n" +
            "  </tr>\r\n" +
            "  <tr>\r\n" +
            "    <td width=\"100%\" style=\"padding:15px\">\r\n" +
            "\r\n" +
            "	    \r\n" +
            "	    \r\n" +
            "	      \r\n" +
            "	        \r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<link type=\"text/css\" HreF=\"/davpublish/wdpr/resources/ehh/css/integratedView.css\" rel=\"stylesheet\" />	\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/jquery/jquery-1.8.2.min.js\"></script>\r\n" +
            "<script type=\"text/javascript\" src=\"/dsfpublishing/wdpr/resources/common/jquery-ui-1.10.2/jquery-19.1.js\"></script>\r\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/common/jquery-ui-1.10.2/ui/minified/jquery.ui.widget.min.js\"></script>\r\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/common/jqplot/jquery.jqplot.min.js\"></script>\r\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/common/jqplot/excanvas.js\"></script>\r\n" +
            "<script type=\"text/javascript\">var $j = jQuery.noConflict();</script>\r\n" +
            "<script type=\"text/javascript\" src=\"/davpublish/wdpr/resources/ehh/scripts/integratedView.js\"></script>	\r\n" +
            "\r\n" +
            "\r\n" +
            "<div id=\"trueTop\"></div>\r\n" +
            "<input type=\"hidden\" name=\"oldAsUser\" id=\"oldAsUser\" value=\"\"/>\r\n" +
            "<input type=\"hidden\" name=\"oldAsPerner\" id=\"oldAsPerner\" value=\"\"/>\r\n" +
            "<form id=\"universalForm\" action=\"/site/dlr/template.MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet.tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252FsubmitAnywhereViaJavascript&beanID=1406643234&viewID=maximized&javax.portlet.begCacheTok=com.vignette.cachetoken&javax.portlet.endCacheTok=com.vignette.cachetoken\">\r\n" +
            "	<input type=\"hidden\" name=\"siteName\" value=\"DLR\" id=\"siteName\">\r\n" +
            "	<input type=\"hidden\" name=\"userLocation\" value=\"unknown\" id=\"userLocation\">\r\n" +
            "	<input type=\"hidden\" name=\"userNameUpper\" value=\"PINEJ034\" id=\"asUserNameUpper\">\r\n" +
            "	<input type=\"hidden\" name=\"pernr\" value=\"00386186\" id=\"asPerner\">\r\n" +
            "	<input type=\"hidden\" name=\"firstName\" value=\"Javier\" id=\"asFirstName\">\r\n" +
            "	<input type=\"hidden\" name=\"lastName\" value=\"Pineda\" id=\"asLastName\">\r\n" +
            "	<input type=\"hidden\" name=\"persArea\" value=\"0113\" id=\"asPersArea\">\r\n" +
            "	<input type=\"hidden\" name=\"orgUnit\" value=\"02\" id=\"asOrgUnit\">\r\n" +
            "	<input type=\"hidden\" name=\"costCenter\" value=\"10001021\" id=\"asCostCenter\">\r\n" +
            "	<input type=\"hidden\" name=\"userNameUpper\" value=\"PINEJ034\" id=\"userNameUpper\">\r\n" +
            "	<input type=\"hidden\" name=\"pernr\" value=\"00386186\" id=\"perner\">\r\n" +
            "	<input type=\"hidden\" name=\"firstName\" value=\"Javier\" id=\"firstName\">\r\n" +
            "	<input type=\"hidden\" name=\"lastName\" value=\"Pineda\" id=\"lastName\">\r\n" +
            "	<input type=\"hidden\" name=\"persArea\" value=\"0113\" id=\"persArea\">\r\n" +
            "	<input type=\"hidden\" name=\"orgUnit\" value=\"02\" id=\"orgUnit\">\r\n" +
            "	<input type=\"hidden\" name=\"costCenter\" value=\"10001021\" id=\"costCenter\">\r\n" +
            "	<input type=\"hidden\" name=\"todayString\" value=\"Thu 12/12\" id=\"todayString\">\r\n" +
            "	<input type=\"hidden\" name=\"currentId\" value=\"\" id=\"currentId\">\r\n" +
            "<input type='hidden' name='javax.portlet.tpst' value='65fa5153808737f60d9cab10b5e26099_ws_MX'/><input type='hidden' name='javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID' value='maximized'/><input type='hidden' name='javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate' value='%2FEHHLSM%2FsubmitAnywhereViaJavascript'/><input type='hidden' name='beanID' value='1406643234'/><input type='hidden' name='viewID' value='maximized'/><input type='hidden' name='javax.portlet.begCacheTok' value='com.vignette.cachetoken'/><input type='hidden' name='javax.portlet.endCacheTok' value='com.vignette.cachetoken'/></form>\r\n" +
            "<table id=\"universalCalTable\" class=\"universalCalTable\"><tr><td valign=\"top\">\r\n" +
            "<div id=\"topMessage2\"><area name='area' id='area' cols='25' rows='5'><div style='border-style:solid;border-width:3px;width:210px;border-color:#666699;BACKGROUND-COLOR:#FFFFE0'><center><strong>Current date (<script type='text/javascript'>var d=new Date();document.write((d.getMonth()+1) +'/'+ d.getDate() +'/'+ d.getFullYear());</script>) does not reflect any day of schedule changes.</strong></center></div><div id='failedChangeUser'>The information you entered is invalid. Please try again.</div></area></div>\r\n" +
            "<div id=\"errorArea\" class=\"ErrorMessageText\"></div>\r\n" +
            "<div class=\"successMsg\" id=\"SuccessMessageText\"></div>\r\n" +
            "<div id=\"LSMQuickAccessPanel\">\r\n" +
            "<div id=\"nameDetail\"></div>\r\n" +
            "<div id=\"quickAccessTitle\" class=\"quickAccessTitle\"><h2>Workforce Management Links</h2></div>\r\n" +
            "\r\n" +
            "	<ul id=\"quickAccessList\" class=\"quickAccessList\">\r\n" +
            "		\r\n" +
            "			\r\n" +
            "			\r\n" +
            "				\r\n" +
            "					<li class=\"quickAccessBullet\"><a href=\"https://enterpriseportal.disney.com/site/dlr/menuitem.427e06f258729e615927f59354276099/index.jsp?epi-content=GENERIC&beanID=2023815463&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=etmdetailview.jsp%3FcontentId%3D457049%26xslFile%3Dwdw_collectioncontainer_fullscreen.xsl%26expDepth%3D2%26xslLoc%3Dcommon%26displayname%3DRequest+Schedules%2C+Vacations%2C+Pay&wsrp-windowState=wsrp:maximized\" onclick=\"helpLinkLoad('<b>RSVP</b>')\" target=\"_newWindow\" title=\"RSVP\"><b>RSVP</b></a></li>\r\n" +
            "				\r\n" +
            "				\r\n" +
            "			\r\n" +
            "		\r\n" +
            "			\r\n" +
            "			\r\n" +
            "				\r\n" +
            "				<br/>\r\n" +
            "			\r\n" +
            "		\r\n" +
            "	</ul>\r\n" +
            "	\r\n" +
            "	\r\n" +
            "\r\n" +
            "	\r\n" +
            "</div>\r\n" +
            "</td>\r\n" +
            "<td valign=\"top\" id=\"calendarCell\" class=\"calendarCellStyle\">\r\n" +
            "	\r\n" +
            "<table><tr><td id=\"topMessageCell\"></td><td id=\"printMessageCell\"><div id=\"printDiv\" class=\"print_caller\"><a href='#' id='printAnchor'><strong>PRINT</strong> <img src='/davpublish/wdpr/resources/ehh/images/smallGreenPrint.bmp' alt='Print Schedule' /></a></div></td></tr></table>\r\n" +
            "\r\n" +
            "\r\n" +
            "<form name=\"CalForm\" id=\"ViewMyScheduleForm\" method=\"post\" action=\"/site/dlr/template.MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet.tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252FViewCalendar.do%253Bjsessionid%253D4504CB874A2337C83347865436446AB9&beanID=1406643234&viewID=maximized&javax.portlet.begCacheTok=com.vignette.cachetoken&javax.portlet.endCacheTok=com.vignette.cachetoken\">\r\n" +
            "	<input type=\"hidden\" name=\"method\" value=\"loadViewMySchedule\" id=\"changeCalMethod\">\r\n" +
            "	<input type=\"hidden\" name=\"asUser\" value=\"PINEJ034\">\r\n" +
            "	<input type=\"hidden\" name=\"asPerner\" value=\"00386186\">\r\n" +
            "	<input type=\"hidden\" name=\"searchPopFlag\" value=\"false\" id=\"searchPopFlag\">\r\n" +
            "	<input type=\"hidden\" name=\"areaId\" value=\"\" id=\"searchAreaId\">\r\n" +
            "	<input type=\"hidden\" name=\"propertyId\" value=\"\" id=\"searchPropertyId\">\r\n" +
            "	<input type=\"hidden\" name=\"lobId\" value=\"\" id=\"searchLobId\">\r\n" +
            "	<input type=\"hidden\" name=\"startDate\" value=\"12/12/2013\" id=\"searchShiftDate\">\r\n" +
            "	<input type=\"hidden\" name=\"action\" value=\"\" id=\"action\">\r\n" +
            "	<input type=\"hidden\" name=\"calOffset\" value=\"0\" id=\"calOffset\">\r\n" +
            "    <table id=\"navTableTop\"><tr><td id=\"etmMessageCellTop\">\r\n" +
            "    <div class=\"etmDiv\">\r\n" +
            "				<a href='#workbrainMessage' name='modal'><strong>View My Time Details</strong></a>\r\n" +
            "				\r\n" +
            "				</div></td>\r\n" +
            "				<td id=\"nextMessageCellTop\"><div class=\"nextDiv\">\r\n" +
            "				<strong>Next Week</strong>\r\n" +
            "				<a href='#' onclick='doNext();' id='nextLink'><img src='/davpublish/wdpr/resources/xpressForms/images/designer/moveRight.png' alt='Move forward a week' /></a>\r\n" +
            "			</div></td></tr></table>\r\n" +
            "	<div id=\"tablewrapper\">\r\n" +
            "	    	<div id=\"tableheader\">\r\n" +
            "			<div class=\"details\"></div>\r\n" +
            "			<div class=\"newForm\"></div>\r\n" +
            "			</div>\r\n" +
            "\r\n" +
            "\r\n" +
            "<div id=\"dayTitle1\"><h2>Previous Week - 12/01/2013 to 12/07/2013</h2></div>\r\n" +
            "		<table class=\"weekDisplay\" id=\"weekDisplay1\">\r\n" +
            "			<tr id=\"calHeader\" class=\"calHeader\">\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Sun 12/01</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Mon 12/02</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Tue 12/03</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Wed 12/04</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Thu 12/05</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Fri 12/06</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Sat 12/07</th>\r\n" +
            "				\r\n" +
            "			</tr>\r\n" +
            "			<tr>\r\n" +
            "				<td class=\"history\" id=\"pastShifts0\">\r\n" +
            "				<input type=\"hidden\" id=\"c0\" name=\"date0\" value=\"Sun 12/01\" />\r\n" +
            "				<div id=\"cellDiv0\"></div><br/>\r\n" +
            "				<div id=\"wbDiv0\"><div id='etmCellDiv0' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c0'>View Time Details</a></div></div>\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"pastShifts1\">\r\n" +
            "				<input type=\"hidden\" id=\"c1\" name=\"date1\" value=\"Mon 12/02\" />\r\n" +
            "				<div id=\"cellDiv1\"></div><br/>\r\n" +
            "				<div id=\"wbDiv1\"><div id='etmCellDiv1' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c1'>View Time Details</a></div></div>\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"pastShifts2\">\r\n" +
            "				<input type=\"hidden\" id=\"c2\" name=\"date2\" value=\"Tue 12/03\" />\r\n" +
            "				<div id=\"cellDiv2\"></div><br/>\r\n" +
            "				<div id=\"wbDiv2\"><div id='etmCellDiv2' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c2'>View Time Details</a></div></div>\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"pastShifts3\">\r\n" +
            "				<input type=\"hidden\" id=\"c3\" name=\"date3\" value=\"Wed 12/04\" />\r\n" +
            "				<div id=\"cellDiv3\"></div><br/>\r\n" +
            "				<div id=\"wbDiv3\"><div id='etmCellDiv3' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c3'>View Time Details</a></div></div>\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"pastShifts4\">\r\n" +
            "				<input type=\"hidden\" id=\"c4\" name=\"date4\" value=\"Thu 12/05\" />\r\n" +
            "				<div id=\"cellDiv4\"></div><br/>\r\n" +
            "				<div id=\"wbDiv4\"><div id='etmCellDiv4' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c4'>View Time Details</a></div></div>\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"pastShifts5\">\r\n" +
            "				<input type=\"hidden\" id=\"c5\" name=\"date5\" value=\"Fri 12/06\" />\r\n" +
            "				<div id=\"cellDiv5\"></div><br/>\r\n" +
            "				<div id=\"wbDiv5\"><div id='etmCellDiv5' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c5'>View Time Details</a></div></div>\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"pastShifts6\">\r\n" +
            "				<input type=\"hidden\" id=\"c6\" name=\"date6\" value=\"Sat 12/07\" />\r\n" +
            "				<div id=\"cellDiv6\"></div><br/>\r\n" +
            "				<div id=\"wbDiv6\"><div id='etmCellDiv6' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c6'>View Time Details</a></div></div>\r\n" +
            "				</td>\r\n" +
            "			</tr>\r\n" +
            "		</table>\r\n" +
            "\r\n" +
            "\r\n" +
            "		\r\n" +
            "		<div id=\"dayTitle2\"><h2>Current Week - 12/08/2013 to 12/14/2013</h2></div>\r\n" +
            "		<table class=\"weekDisplay\" id=\"weekDisplay2\">\r\n" +
            "			<tr id=\"calHeader2\" class=\"calHeader\">\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Sun 12/08</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Mon 12/09</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Tue 12/10</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Wed 12/11</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Thu 12/12</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Fri 12/13</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Sat 12/14</th>\r\n" +
            "				\r\n" +
            "			</tr>\r\n" +
            "			<tr>\r\n" +
            "				<td class=\"history\" id=\"presentShifts7\">\r\n" +
            "				<input type=\"hidden\" id=\"c7\" name=\"date7\" value=\"Sun 12/08\" />\r\n" +
            "				\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck7\" id=\"dayCheck7\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_7\" id=\"dayCheck2_7\" value=\"\"/>\r\n" +
            "				<div id=\"dayCheckDiv7\"></div>\r\n" +
            "				<div id=\"cellDiv7\" class=\"PastClass\">	\r\n" +
            "				 \r\n" +
            "					</div>\r\n" +
            "						\r\n" +
            "						<div id=\"wbDiv7\"><div id='etmCellDiv7' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c7'>View Time Details</a></div></div>\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"presentShifts8\">\r\n" +
            "				<input type=\"hidden\" id=\"c8\" name=\"date8\" value=\"Mon 12/09\" />\r\n" +
            "				\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck8\" id=\"dayCheck8\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_8\" id=\"dayCheck2_8\" value=\"\"/>\r\n" +
            "				<div id=\"dayCheckDiv8\"></div>\r\n" +
            "				<div id=\"cellDiv8\" class=\"PastClass\">	\r\n" +
            "				 \r\n" +
            "					</div>\r\n" +
            "						\r\n" +
            "						<div id=\"wbDiv8\"><div id='etmCellDiv8' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c8'>View Time Details</a></div></div>\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"presentShifts9\">\r\n" +
            "				<input type=\"hidden\" id=\"c9\" name=\"date9\" value=\"Tue 12/10\" />\r\n" +
            "				\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck9\" id=\"dayCheck9\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_9\" id=\"dayCheck2_9\" value=\"\"/>\r\n" +
            "				<div id=\"dayCheckDiv9\"></div>\r\n" +
            "				<div id=\"cellDiv9\" class=\"PastClass\">	\r\n" +
            "				 \r\n" +
            "					</div>\r\n" +
            "						\r\n" +
            "						<div id=\"wbDiv9\"><div id='etmCellDiv9' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c9'>View Time Details</a></div></div>\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"presentShifts10\">\r\n" +
            "				<input type=\"hidden\" id=\"c10\" name=\"date10\" value=\"Wed 12/11\" />\r\n" +
            "				\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck10\" id=\"dayCheck10\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_10\" id=\"dayCheck2_10\" value=\"\"/>\r\n" +
            "				<div id=\"dayCheckDiv10\"></div>\r\n" +
            "				<div id=\"cellDiv10\" class=\"PastClass\">	\r\n" +
            "				 \r\n" +
            "					</div>\r\n" +
            "						\r\n" +
            "						<div id=\"wbDiv10\"><div id='etmCellDiv10' class='etmCellPosition'><a href='#workbrainMessage' name='modal' id='c10'>View Time Details</a></div></div>\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"presentShifts11\">\r\n" +
            "				<input type=\"hidden\" id=\"c11\" name=\"date11\" value=\"Thu 12/12\" />\r\n" +
            "				\r\n" +
            "				<div id=\"currentDayMessage\"><div id='TodayClass1' class='TodayClass1'></div></div>\r\n" +
            "				\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck11\" id=\"dayCheck11\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_11\" id=\"dayCheck2_11\" value=\"\"/>\r\n" +
            "				<div id=\"dayCheckDiv11\"></div>\r\n" +
            "				<div id=\"cellDiv11\" class=\"TodayClass\">	\r\n" +
            "				 			\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >13:15-21:30</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div><p/>		\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "						\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"presentShifts12\">\r\n" +
            "				<input type=\"hidden\" id=\"c12\" name=\"date12\" value=\"Fri 12/13\" />\r\n" +
            "				\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck12\" id=\"dayCheck12\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_12\" id=\"dayCheck2_12\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv12\"></div>\r\n" +
            "				<div id=\"cellDiv12\" class=\"TodayClass\">	\r\n" +
            "				 			\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >14:00-22:30</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div><p/>		\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "						\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "				<td class=\"history\" id=\"presentShifts13\">\r\n" +
            "				<input type=\"hidden\" id=\"c13\" name=\"date13\" value=\"Sat 12/14\" />\r\n" +
            "				\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck13\" id=\"dayCheck13\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_13\" id=\"dayCheck2_13\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv13\"></div>\r\n" +
            "				<div id=\"cellDiv13\" class=\"TodayClass\">	\r\n" +
            "				 			\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >15:30-00:00</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div><p/>		\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "						\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "			</tr>\r\n" +
            "		</table>\r\n" +
            "\r\n" +
            "\r\n" +
            "		\r\n" +
            "		<div id=\"dayTitle3\"><h2>Next Week - 12/15/2013 to 12/21/2013</h2></div>\r\n" +
            "		<table class=\"weekDisplay\" id=\"weekDisplay3\">\r\n" +
            "			<tr id=\"calHeader3\" class=\"calHeader\">\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Sun 12/15</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Mon 12/16</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Tue 12/17</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Wed 12/18</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Thu 12/19</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Fri 12/20</th>\r\n" +
            "				\r\n" +
            "					<th class=\"nowrapCell\">Sat 12/21</th>\r\n" +
            "				\r\n" +
            "			</tr>\r\n" +
            "			<tr>\r\n" +
            "				<td class=\"history\" id=\"futureShifts14\">\r\n" +
            "				<input type=\"hidden\" id=\"c14\" name=\"date14\" value=\"Sun 12/15\" />\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck14\" id=\"dayCheck14\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_14\" id=\"dayCheck2_14\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv14\"></div>\r\n" +
            "				<div id=\"cellDiv214\">\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >14:45-23:15</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div>\r\n" +
            "						<p/>\r\n" +
            "							\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					</td>\r\n" +
            "				<td class=\"history\" id=\"futureShifts15\">\r\n" +
            "				<input type=\"hidden\" id=\"c15\" name=\"date15\" value=\"Mon 12/16\" />\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck15\" id=\"dayCheck15\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_15\" id=\"dayCheck2_15\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv15\"></div>\r\n" +
            "				<div id=\"cellDiv215\">\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >14:00-22:30</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div>\r\n" +
            "						<p/>\r\n" +
            "							\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					</td>\r\n" +
            "				<td class=\"history\" id=\"futureShifts16\">\r\n" +
            "				<input type=\"hidden\" id=\"c16\" name=\"date16\" value=\"Tue 12/17\" />\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck16\" id=\"dayCheck16\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_16\" id=\"dayCheck2_16\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv16\"></div>\r\n" +
            "				<div id=\"cellDiv216\">\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >14:30-22:30</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div>\r\n" +
            "						<p/>\r\n" +
            "							\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					</td>\r\n" +
            "				<td class=\"history\" id=\"futureShifts17\">\r\n" +
            "				<input type=\"hidden\" id=\"c17\" name=\"date17\" value=\"Wed 12/18\" />\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck17\" id=\"dayCheck17\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_17\" id=\"dayCheck2_17\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv17\"></div>\r\n" +
            "				<div id=\"cellDiv217\">\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >14:00-22:30</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div>\r\n" +
            "						<p/>\r\n" +
            "							\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					</td>\r\n" +
            "				<td class=\"history\" id=\"futureShifts18\">\r\n" +
            "				<input type=\"hidden\" id=\"c18\" name=\"date18\" value=\"Thu 12/19\" />\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck18\" id=\"dayCheck18\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_18\" id=\"dayCheck2_18\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv18\"></div>\r\n" +
            "				<div id=\"cellDiv218\">\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						<div class=\"shiftCellClass\">\r\n" +
            "						  <span class=\"date\" >15:15-23:30</span>\r\n" +
            "						  <span class=\"position\" >Racers HH -  </span>\r\n" +
            "						</div>\r\n" +
            "						<p/>\r\n" +
            "							\r\n" +
            "					\r\n" +
            "					\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					</td>\r\n" +
            "				<td class=\"history\" id=\"futureShifts19\">\r\n" +
            "				<input type=\"hidden\" id=\"c19\" name=\"date19\" value=\"Fri 12/20\" />\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck19\" id=\"dayCheck19\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_19\" id=\"dayCheck2_19\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv19\"></div>\r\n" +
            "				<div id=\"cellDiv219\">\r\n" +
            "							\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						<div class=\"availCellClass\">\r\n" +
            "						  <span class=\"availDate\" ></span>\r\n" +
            "						  <span class=\"reason\" >RDO                                </span>\r\n" +
            "					    </div>\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					</td>\r\n" +
            "				<td class=\"history\" id=\"futureShifts20\">\r\n" +
            "				<input type=\"hidden\" id=\"c20\" name=\"date20\" value=\"Sat 12/21\" />\r\n" +
            "				\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck20\" id=\"dayCheck20\" value=\"\"/>\r\n" +
            "				<input type=\"hidden\" name=\"dayCheck2_20\" id=\"dayCheck2_20\" value=\"success\"/>\r\n" +
            "				<div id=\"dayCheckDiv20\"></div>\r\n" +
            "				<div id=\"cellDiv220\">\r\n" +
            "							\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						<div class=\"availCellClass\">\r\n" +
            "						  <span class=\"availDate\" ></span>\r\n" +
            "						  <span class=\"reason\" >RDO                                </span>\r\n" +
            "					    </div>\r\n" +
            "					<p/>\r\n" +
            "					\r\n" +
            "					</div>\r\n" +
            "					\r\n" +
            "						\r\n" +
            "						\r\n" +
            "							\r\n" +
            "						\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					\r\n" +
            "					</td>\r\n" +
            "			</tr>\r\n" +
            "		</table><br/>\r\n" +
            "		<table id=\"navTableBottom\"><tr><td id=\"etmMessageCellBottom\"><div class=\"etmDiv\">\r\n" +
            "				<a href='#workbrainMessage' name='modal'><strong>View My Time Details</strong></a>\r\n" +
            "				\r\n" +
            "				</div></td>\r\n" +
            "				<td id=\"nextMessageCellBottom\"><div class=\"nextDiv\">\r\n" +
            "				<strong>Next Week</strong>\r\n" +
            "				<a href='#' onclick='doNext();' id='nextLink'><img src='/davpublish/wdpr/resources/xpressForms/images/designer/moveRight.png' alt='Move forward a week' /></a>\r\n" +
            "			</div></td></tr></table>\r\n" +
            "		\r\n" +
            "		</div>\r\n" +
            "		<input type=\"hidden\" name=\"publishExceeded\" value=\"\" id=\"publishExceeded\">\r\n" +
            "<br/>\r\n" +
            "<input type=\"hidden\" name=\"todayIndex\" value=\"11\" id=\"todayIndex\">\r\n" +
            "	<div id=\"messageArea\"></div>\r\n" +
            "</form>\r\n" +
            "\r\n" +
            "\r\n" +
            "</td></tr>\r\n" +
            "<tr>\r\n" +
            "<td colspan=\"2\">\r\n" +
            "<div id=\"eligDiv\" class=\"eligDiv\">\r\n" +
            "    <table id=\"eligTable\" class=\"elibTable\">\r\n" +
            "			<tr><td colspan=\"2\" class=\"moduleBanner\">Eligibility For PINEJ034</td></tr>\r\n" +
            "            <tr><td colspan=\"2\" class=\"moduleBackground\">PREVIOUS EHH USER... <br/>Verify Cast Member name ... <strong>Javier Pineda</strong><br/>Checking VISA eligibility ...DONE<br/>Checking OVERUTILIZED eligibility ...DONE<br/>Checking MINOR eligibility ...DONE<br/>Checking EHH record ...UPDATE USER</font> ... DONE<br/>DONE<br/></td></tr>\r\n" +
            "            \r\n" +
            "        	<tr><td	colspan=\"2\" class=\"moduleBackground\"></td></tr>\r\n" +
            "        	<tr><td colspan=\"2\">\r\n" +
            "    \r\n" +
            "    			<br/>This user is eligible to pick up Open Shifts (EHH) and his/her restrictions have been loaded.  See messages above for further explanation.<br/>\r\n" +
            "                 </td>\r\n" +
            "            </tr>\r\n" +
            "    \r\n" +
            "	</table></div>\r\n" +
            "</td></tr></table>\r\n" +
            "\r\n" +
            "	\r\n" +
            "		<script type=\"text/javascript\">$j('#eligDiv').show();$j('#eligTable').show();</script>\r\n" +
            "	\r\n" +
            "	\r\n" +
            "\r\n" +
            "<div id=\"trueBottom\"></div>\r\n" +
            "\r\n" +
            "<div style=\"display:none;\">00386186 test schedule.result= Shift:</div>\r\n" +
            "<form name=\"EhhForm\" id=\"searchShiftsForm\" method=\"post\" action=\"/site/dlr/template.MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet.tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252Fehh.do%253Bjsessionid%253D4504CB874A2337C83347865436446AB9&beanID=1406643234&viewID=maximized&javax.portlet.begCacheTok=com.vignette.cachetoken&javax.portlet.endCacheTok=com.vignette.cachetoken\">\r\n" +
            "  	<input type=\"hidden\" name=\"method\" value=\"searchShifts\" id=\"filterMethod\">\r\n" +
            "	<input type=\"hidden\" name=\"asUser\" value=\"PINEJ034\" id=\"filterUserPortal\">\r\n" +
            "	<input type=\"hidden\" name=\"asPerner\" value=\"00386186\" id=\"filterUserPerner\">\r\n" +
            "	<input type=\"hidden\" name=\"portalId\" value=\"PINEJ034\" id=\"originalPortal\">\r\n" +
            "	<input type=\"hidden\" name=\"proxyId\" value=\"\" id=\"originalProxy\">\r\n" +
            "	<input type=\"hidden\" name=\"action\" value=\"\" id=\"searchAction\">\r\n" +
            "	<input type=\"hidden\" name=\"shiftId\" value=\"0\" id=\"searchShiftId\">\r\n" +
            "	<input type=\"hidden\" name=\"propertyId\" value=\"0\" id=\"propertyId\">\r\n" +
            "	<input type=\"hidden\" name=\"areaId\" value=\"0\" id=\"areaId\">\r\n" +
            "	<input type=\"hidden\" name=\"locationId\" value=\"0\" id=\"locationId\">\r\n" +
            "	<input type=\"hidden\" name=\"lobId\" value=\"0\" id=\"lobId\">\r\n" +
            "	<input type=\"hidden\" name=\"startDate\" value=\"12/12/2013\" id=\"startDate\">\r\n" +
            "	<input type=\"hidden\" name=\"endDate\" value=\"\" id=\"endDate\">\r\n" +
            "	<br/><input type=\"button\" name=\"action\" value=\"Search\" onclick=\"doISVSearch();\" id=\"searchEhhShiftsButton\">\r\n" +
            "</form>\r\n" +
            "\r\n" +
            "<div id=\"workbrainMessage\"></div>\r\n" +
            "	      \r\n" +
            "	      \r\n" +
            "	    \r\n" +
            "\r\n" +
            "    </td>\r\n" +
            "  </tr>\r\n" +
            "</table>\r\n" +
            "\r\n" +
            "\r\n" +
            "					<!-- End pageContent -->\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "\r\n" +
            "				\r\n" +
            "				<td width=\"213\" class=\"quickAccessPanelStyle\" valign=\"top\">\r\n" +
            "					<!-- FAST Search implementation goes here  --> \r\n" +
            "					\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- FAST SIMPLE SEARCH -->\r\n" +
            "<div id=\"enterpriseSearch\">\r\n" +
            "	<form action=\"index.jsp?epi-content=GENERIC&beanID=1326258214&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=search_results.jsp&wsrp-windowState=wsrp:maximized\"  method=\"get\" name=\"ess_search_form\" onsubmit=\"return validateDEPSearchForm (this)\"><input type=\"hidden\" name=\"epi-content\" value=\"GENERIC\"></input><input type=\"hidden\" name=\"beanID\" value=\"1326258214\"></input><input type=\"hidden\" name=\"viewID\" value=\"maximized\"></input><input type=\"hidden\" name=\"wsrp-mode\" value=\"wsrp:view\"></input><input type=\"hidden\" name=\"wsrp-navigationalState\" value=\"search_results.jsp\"></input><input type=\"hidden\" name=\"wsrp-windowState\" value=\"wsrp:maximized\"></input><input type=\"hidden\" name=\"dep-isForm\" value=\"true\"></input>\r\n" +
            "		<fieldset>\r\n" +
            "			<input type=\"text\" name=\"ess_search_query\" value=\"\" autocomplete=\"on\"/>\r\n" +
            "                        \r\n" +
            "			<input class=\"Button\" type=\"Submit\" value=\"Search\" />\r\n" +
            "		</fieldset>\r\n" +
            "		<fieldset>\r\n" +
            "			<select name='ess_search_siteSelection'>  <option  value='this'>DLR only  <option selected value='all'>All sites</option>  <option  value='people'>People</option></select>\r\n" +
            "            			\r\n" +
            "			 <label><a href=\"index.jsp?epi-content=GENERIC&beanID=1326258214&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=advanced_search.jsp&wsrp-windowState=wsrp:maximized\">Advanced Search</a></label>\r\n" +
            "			\r\n" +
            "			\r\n" +
            "			 <label><a href=\"http://enterpriseportal.disney.com/site/team/index.jsp?epi-content=RAW&epiproxymethod=get&viewID=epiproxybanner&beanID=1864233772&epiproxyrealurl=https://presto.disney.com/enterprise-it/strategic-services/strategy-policy/knowledge-management-strategy/portal-search-help.html\" target=\"_blank\">Help</a></label>\r\n" +
            "			\r\n" +
            "            \r\n" +
            "		</fieldset>\r\n" +
            "	</form>\r\n" +
            "</div>\r\n" +
            "\r\n" +
            "<script>\r\n" +
            "\r\n" +
            "	\r\n" +
            "function determineSearchTarget (searchForm)\r\n" +
            "{\r\n" +
            "	var siteSelector = searchForm.ess_search_siteSelection;\r\n" +
            " if (siteSelector == null) {\r\n" +
            "      return true;\r\n" +
            " }\r\n" +
            "	var i = null;\r\n" +
            " if (siteSelector.type != 'hidden') {\r\n" +
            "       i = searchForm.ess_search_siteSelection.options.selectedIndex;\r\n" +
            " }\r\n" +
            "	if ((siteSelector.type != 'hidden') && (searchForm.ess_search_siteSelection.options [i].value=='people'))\r\n" +
            "	{\r\n" +
            "		var queryString = searchForm.ess_search_query.value;\r\n" +
            "		if (queryString == null || queryString == '')\r\n" +
            "		{\r\n" +
            "			if (searchForm.name == 'ess_search_results_form')\r\n" +
            "			{\r\n" +
            "				queryString = searchForm.ess_search_prevQueryString.value;\r\n" +
            "			}\r\n" +
            "		}\r\n" +
            "		var contactsURL = \"https://contacts.disney.com/?stype=startw&portal=1&ssect=people&stext=\"+queryString;\r\n" +
            "		window.open (contactsURL, 'Contacts', '');\r\n" +
            "		return false;\r\n" +
            "	}\r\n" +
            "	else\r\n" +
            "	{\r\n" +
            "		return true;\r\n" +
            "	}\r\n" +
            "}\r\n" +
            "\r\n" +
            "function essTrim(str)\r\n" +
            "{\r\n" +
            "  return str.replace(/^\\s*|\\s*$/g,'');\r\n" +
            "}\r\n" +
            "\r\n" +
            "function essIsEmpty(str)\r\n" +
            "{\r\n" +
            "   if (str == null) return true;\r\n" +
            "   str = essTrim (str);\r\n" +
            "   if (str.length == 0) return true;\r\n" +
            "   return false;\r\n" +
            "}\r\n" +
            "function essStripCharacters (inStr)  \r\n" +
            "{  \r\n" +
            "	var stripCharacters = '#%&+-/\\\\;<>=@[]{}_`|~()^$!:.';  \r\n" +
            "	var newStr = \"\";  \r\n" +
            "	for (var i = 0; i < inStr.length; i++)  \r\n" +
            "	{  \r\n" +
            "		var thisChar = inStr.charAt (i);  \r\n" +
            "		if (stripCharacters.indexOf (thisChar) >= 0)  \r\n" +
            "		{  \r\n" +
            "			newStr += ' ';  \r\n" +
            "		}  \r\n" +
            "		else  \r\n" +
            "		{  \r\n" +
            "			newStr += thisChar;  \r\n" +
            "		}  \r\n" +
            "	}  \r\n" +
            "	return newStr;  \r\n" +
            "}\r\n" +
            "            \r\n" +
            "        \r\n" +
            "\r\n" +
            "	function validateDEPSearchForm (thisForm)\r\n" +
            "	{\r\n" +
            "		//alert (\"In validateDEPSearchForm!!!\");\r\n" +
            "		// Make sure we have some input...\r\n" +
            "		var queryString = thisForm.ess_search_query.value;\r\n" +
            "\r\n" +
            "		// strip out all useless control characters, and\r\n" +
            "		// put it back in the form\r\n" +
            "		queryString = essStripCharacters (queryString);\r\n" +
            "		thisForm.ess_search_query.value = queryString;\r\n" +
            "\r\n" +
            "		//alert (\"queryString=\"+queryString);\r\n" +
            "		if (essIsEmpty (queryString))\r\n" +
            "		{\r\n" +
            "			alert (\"Please enter a search term.\");\r\n" +
            "			thisForm.ess_search_query.focus ();\r\n" +
            "			return false;\r\n" +
            "		}\r\n" +
            "\r\n" +
            "		// Determine whether we should post to \r\n" +
            "		return determineSearchTarget (thisForm);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "</script>\r\n" +
            "<!-- END FAST SIMPLE SEARCH -->\r\n" +
            "\r\n" +
            "\r\n" +
            " \r\n" +
            "					<!--  End FAST Search implementation --> \r\n" +
            "					\r\n" +
            "\r\n" +
            "					\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- Start Module Chrome -->\r\n" +
            "\r\n" +
            "<table class='mdtQuickAcessPanel' width='213' border='0' cellspacing='0' cellpadding='0' >\r\n" +
            "	<tr>\r\n" +
            "		<td>\r\n" +
            "			<table width=\"100%\" border=\"0\"  cellspacing=\"0\" cellpadding=\"0\" class=\"mdt_QAP_Banner\">\r\n" +
            "				<tr>\r\n" +
            "					<td align=\"right\" valign=\"top\" class=\"mdt_QAP_Toolbar\" >			\r\n" +
            "					</td>\r\n" +
            "				</tr>\r\n" +
            "			</table>\r\n" +
            "		</td>\r\n" +
            "	</tr>\r\n" +
            "	\r\n" +
            "	<tr class=\"mdt_QAP_Background\">\r\n" +
            "		<td>\r\n" +
            "			<table width=\"100%\" border=\"0\"  cellspacing=\"0\" cellpadding=\"0\" class=\"mdt_QAP_Gradient\" id=\"mdt_QAP_Gradient\">\r\n" +
            "				<tr>\r\n" +
            "					<td class='mdt_QAP_View' valign='top'>\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- Start Quick Access Module -->\r\n" +
            "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" name=\"FeatMod\">\r\n" +
            "  <tr>\r\n" +
            "    <td align=\"left\" valign=\"top\">\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "</td></tr><tr><td>\r\n" +
            "</td></tr><tr><td>\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- Start rostr module -->\r\n" +
            "<div id=\"rostr_widget\">\r\n" +
            "	<script src=\"https://rostr.disney.com/widget/search/search.nocache.js\" type=\"text/javascript\"></script>\r\n" +
            "	<div id=\"rostr_search_widget\"> </div>\r\n" +
            "	<p class=\"rostr_contacts_link\">\r\n" +
            "		<a target=\"_new\" href=\"https://contacts.disney.com\">CONTACTS</a>\r\n" +
            "	</p>\r\n" +
            "</div>\r\n" +
            "<!-- end rostr module --></td></tr><tr><td>\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- Start Module Chrome -->\r\n" +
            "<table class='mdt_quickAccessModule' width='100%' border='0' cellspacing='0' cellpadding='0' align='CENTER'>\r\n" +
            "\r\n" +
            "		<tr>\r\n" +
            "			<td>\r\n" +
            "			<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" class=\"mdt_QAP_moduleHeaderQuickLinks\">\r\n" +
            "				<tr>\r\n" +
            "			<!-- Display the Welcome user line -->\r\n" +
            "			<td nowrap class=\"mdt_QAP_moduleBanner\"><img src=\"/gopublish/sitemedia/Image/icn-quicklinks.gif\" align=\"TOP\" alt=\"\">&nbsp;Quick Links</td>\r\n" +
            "			<td nowrap class=\"mdt_QAP_moduleToolbar\">&nbsp;\r\n" +
            "				<a href=\"/site/dlr/index.jsp?epi-content=GENERIC&viewID=USER_BEAN_EDIT_VIEW&beanID=122819324\"><img src=\"/templates/ZaXbRfRQXTdVZYUSbWXaYRRVVUSXWQZZ/UacaTfbTQaVdUefXVcSWdTdQVUSXWQZZ/module_edit_sm.gif\" alt=\"customize this module\" border=\"0\" WIDTH=\"27\" HEIGHT=\"12\"></a>\r\n" +
            "			</td>\r\n" +
            "			</tr>\r\n" +
            "			</table>\r\n" +
            "			</td>\r\n" +
            "		</tr>\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "				<tr>\r\n" +
            "					<td valign=\"top\" class=\"mdt_QAP_moduleView\">\r\n" +
            "\r\n" +
            "\r\n" +
            "<epi_html:controllerURL />\r\n" +
            "\r\n" +
            "<!-- Start Quick Links Module -->\r\n" +
            "\r\n" +
            "<script language=\"javascript\">\r\n" +
            "\r\n" +
            "	function qlOpenWindow( url, type )\r\n" +
            "	{\r\n" +
            "		window.name     = \"portal_root\";\r\n" +
            "		window.rootopen = \"true\";\r\n" +
            "		w               = window.open(url, type, \"toolbar=no,  location=no, directories=no, status=yes, menubar=yes, scrollbars=yes, resizable=yes, left=0, top=0\");\r\n" +
            "		window.setTimeout('w.focus()',100);\r\n" +
            "		return;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	function qlOpenWindow2( url, type )\r\n" +
            "	{\r\n" +
            "		window.name     = \"portal_root\";\r\n" +
            "		window.rootopen = \"true\";\r\n" +
            "		w2              = window.open(url, type, \"toolbar=yes, location=no, directories=no, status=yes, menubar=yes, scrollbars=yes, resizable=yes, left=0, top=0\");\r\n" +
            "		window.setTimeout('w2.focus()',100);\r\n" +
            "		return;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "</script>\r\n" +
            "\r\n" +
            "<div id=\"quicklinks_module\">\r\n" +
            "<!-- current profile\r\n" +
            "		user id:    1568370\r\n" +
            "		user login: PINEJ034\r\n" +
            "		user email: PINEJ034\r\n" +
            "		user name:  Javier Pineda\r\n" +
            "	-->\r\n" +
            "		<div class=\"teamLinks\">\r\n" +
            "		<div class=\"quickLinkHeading\">TEAM Links</div>\r\n" +
            "		<small>\r\n" +
            "		<ul>\r\n" +
            "		\r\n" +
            "				<li><a href=\"https://efs.disney.com:9031/idp/startSSO.ping?PartnerSpId=urn:sp:fidelity:geninbndnbparts20&TargetResource=https%3A%2F%2Fdisney.fidelity.com%2Fftgw%2Fewcd%2Fhome\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Add It Up! Online';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Add It Up! Online</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"https://enterpriseportal.disney.com/site/wdw/index.jsp?epi-content=GENERIC&beanID=44256032&viewID=MY_PORTAL_VIEW&button=QuickLink_ComplimentaryAdmission\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Complimentary Admission';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Complimentary Admission</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/team/menuitem.2b652f691366c6d0a7e7f992faac01ca/index.jsp?epi-content=GENERIC&beanID=2046049605&viewID=MY_PORTAL_VIEW&button=QuickLink_DisneyIT\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disney I.T.';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disney I.T.</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/team/template.MAXIMIZE/menuitem.8bacaaa748106daf4727f59354276099/?javax.portlet.tpst=7798cd3fc3c482eb06ba6327b7653a33_ws_MX&javax.portlet.prp_7798cd3fc3c482eb06ba6327b7653a33_viewID=safeharborchk_process&app=elp&button=QuickLink_DevelopmentConnection\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Development Connection';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Development Connection</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"index.jsp?epi-content=GENERIC&viewID=MY_PORTAL_VIEW&beanID=683161281&button=QuickLink_DisneyInventors\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disney Inventors';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disney Inventors</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.sap.pct.erp.ess.wda.bp_folder/com.sap.pct.erp.ess.wda.iviews/com.sap.pct.erp.ess.wda.overview_external\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Employee Services';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Employee Services</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.swna.wdpr.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_PERSINFO&WebDynproConfiguration=HRESS_AC_PERSINFO&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Paycard/Direct Deposit';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Paycard/Direct Deposit</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_PERSINFO&WebDynproConfiguration=HRESS_AC_PERSINFO&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Paycard/Direct Deposit';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Paycard/Direct Deposit</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/gopublish/sitemedia/TDO/HR/EmpPolicies_index.html\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Employee Policies';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Employee Policies</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_CATS_1&WebDynproConfiguration=HRESS_AC_CATS_1&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Enter My Time (SAP)';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Enter My Time (SAP)</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/team/menuitem.2b652f691366c6d0a7e7f992faac01ca/index.jsp?epi-content=GENERIC&viewID=MY_PORTAL_VIEW&beanID=913246064&button=QuickLink_GlobalSecurity\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Global Security';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Global Security</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/gopublish/sitemedia/TDO/HR/Talent_Acquisition/MyDisneyCareer/index.html\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: My Disney Career';return true;\" onMouseOut=\"javascript:top.status='';return true;\">My Disney Career</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"https://enterpriseportal.disney.com/site/team/index.jsp?epi_menuItemID=2b652f691366c6d0a7e7f992faac01ca&epi_menuID=9bbbfcf8ee100b7f4727f59354276099&epi_baseMenuID=9bbbfcf8ee100b7f4727f59354276099&DEPTaxonomyNode-8963840233b17e88177a8115f9ac01ca=6522&button=QuickLink_PerformanceConnection\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Performance Connection';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Performance Connection</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/wdw/index.jsp?epi-content=GENERIC&beanID=1876682105&viewID=MY_PORTAL_VIEW&button=QuickLink_SAPHelp\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: SAP Help';return true;\" onMouseOut=\"javascript:top.status='';return true;\">SAP Help</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.swna.wdpr.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.twdc.fl.express/com.twdc.fl.roles/com.twdc.rl.express\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Portal Express';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Portal Express</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.swna.wdpr.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.TWDC.fl.PUN/com.TWDC.fl.PUNRoles/com.TWDC.rl.sap_work_place\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: SAP Work Place';return true;\" onMouseOut=\"javascript:top.status='';return true;\">SAP Work Place</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/team/index.jsp?epi-content=GENERIC&beanID=1084606812&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=ViewID%3DArticleDetail%26ContentID%3D570168&wsrp-windowState=wsrp:maximized&button=QuickLink_StandardsofBusinessConductTranslated\" target=\"_top\" title=\"Standards of Business Conduct\" onMouseOver=\"javascript:top.status='Quick Link: Standards of Business Conduct';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Standards of Business...</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"https://efs.disney.com:9031/idp/startSSO.ping?PartnerSpId=augustus.iqnavigator.com\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Temp Staffing/Zerochaos';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Temp Staffing/Zerochaos</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"javascript:void(window.open('http://mypersonal.swna.wdpr.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.TWDC.fl.TWDC/com.TWDC.fl.ESS/com.TWDC.fl.time_and_pay/com.TWDC.fl.taxes/com.TWDC.fl.taxes_pages/com.TWDC.pg.view_w-2','SAP','menubar,status,scrollbars,resizable'))\r\n" +
            "\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: W2 Online/Multi St. Policy';return true;\" onMouseOut=\"javascript:top.status='';return true;\">W2 Online/Multi St. Policy</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_PAYSLIP&WebDynproConfiguration=ZHRESS_AC_PAYSLIP&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: View Paystub Online';return true;\" onMouseOut=\"javascript:top.status='';return true;\">View Paystub Online</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/team/menuitem.b1b4d4b7e046c366694b2f13f9ac01ca/index.jsp?epi-content=GENERIC&dsfnavstate=%252FPayroll_Services%252FPayrollServices_index.jsp&beanID=1333946875&viewID=maximized&button=QuickLink_PayrollServices_External\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Payroll Services';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Payroll Services</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mypersonal.disney.com/irj/portal?NavigationTarget=ROLES://portal_content/com.sap.pct/every_user/com.sap.pct.erp.common.bp_folder/com.sap.pct.erp.common.roles/com.sap.pct.erp.common.erp_common/com.sap.pct.erp.common.lpd_start_wd_abap&ApplicationParameter=&System=SAP_ECC_HumanResources&WebDynproApplication=HRESS_A_PTARQ_TIMEACC&WebDynproConfiguration=HRESS_AC_PTARQ_TIMEACC&WebDynproNamespace=sap&NavMode=3\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: View Available Time Off';return true;\" onMouseOut=\"javascript:top.status='';return true;\">View Available Time Off</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"https://enterpriseportal.disney.com/site/team/index.jsp?epi-content=GENERIC&beanID=1084606812&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=ViewID%3DArticleDetail%26ContentID%3D608868&wsrp-windowState=wsrp:maximized&button=QuickLink_YourDiscounts\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Your Discounts';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Your Discounts</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/wdpr/index.jsp/?epi-content=GENERIC&beanID=1916562460&viewID=MY_PORTAL_VIEW&button=QuickLink_WDPRLeadership\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: WDPR Leadership';return true;\" onMouseOut=\"javascript:top.status='';return true;\">WDPR Leadership</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"javascript:void(window.open('https://mypersonal.disney.com/r3webdynpro/dispatcher/twdc.com/r3~hr~m18rec/RecCardApp','SAP','menubar,status,scrollbars,resizable'))\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: View Record Card';return true;\" onMouseOut=\"javascript:top.status='';return true;\">View Record Card</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://centerstage.nena.wdpr.disney.com\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: CenterStage';return true;\" onMouseOut=\"javascript:top.status='';return true;\">CenterStage</a></li>\r\n" +
            "			\r\n" +
            "		</ul></small></div>\r\n" +
            "		\r\n" +
            "		<a class=\"addThisPage\" target=\"_top\" href=\"/site/dlr/index.jsp?epi-content=GENERIC&beanID=122819324&viewID=add_this_link\">&lt;- Add This Page</a>\r\n" +
            "		\r\n" +
            "		<div class=\"quickLinks\">\r\n" +
            "		<div class=\"quickLinkHeading myLinks\">My Links</div>\r\n" +
            "		<!-- ol style=\"margin:0;padding:0;list-style-position:inside;color:#666666\" -->\r\n" +
            "		<small><ul>\r\n" +
            "				<li><a href=\"https://enterpriseportal.disney.com/site/dlr/menuitem.427e06f258729e615927f59354276099/&\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Work Schedule';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Work Schedule</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/wdw_generic.jsp?textID=depotwsrpconsumer134_DLRCastLink&viewID=MY_PORTAL_VIEW\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Cast Link';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Cast Link</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/index.jsp?epi-content=GENERIC&beanID=965211087&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=contentId%3D124505%26xslFile%3Dwdw_policy.xsl%26expDepth%3D2%26xslLoc%3Dcommon&wsrp-windowState=wsrp:maximized&displayname=WDP%26R+Print+Publications\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disneyland Resort Line';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disneyland Resort Line</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://enterpriseportal.disney.com/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/index.jsp?epi-content=GENERIC&beanID=965211087&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=contentId%3D599301%26xslFile%3Dwdw_article.xsl%26expDepth%3D2%26xslLoc%3Dcommon&wsrp-windowState=wsrp:maximized&displayname=WDPR+Video%3Cbr%3E%3Cbr%3E\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: CAST TV';return true;\" onMouseOut=\"javascript:top.status='';return true;\">CAST TV</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://dlr-cds.wdw.disney.com\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: DLR-CDS';return true;\" onMouseOut=\"javascript:top.status='';return true;\">DLR-CDS</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"https://enterpriseportal.disney.com/site/dlr/index.jsp?epi-content=GENERIC&beanID=1885976808&viewID=MY_PORTAL_VIEW&\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Labor Tool Box';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Labor Tool Box</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://dm-caan-ww001/webeditor\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: DLR SmarTeam-Animal';return true;\" onMouseOut=\"javascript:top.status='';return true;\">DLR SmarTeam-Animal</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"https://burbank-backstagepass.disney.com\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Backstage Pass - Burbank';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Backstage Pass - Burbank</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://disneycontacts.corp.disney.com/disneycontacts.asp\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: DLR Phone Directory';return true;\" onMouseOut=\"javascript:top.status='';return true;\">DLR Phone Directory</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/site/dlr/index.jsp?epi-content=GENERIC&beanID=351283989&viewID=MY_PORTAL_VIEW&\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Cast Dining';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Cast Dining</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://fl.wdi.disney.com/trivia/\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: WDI Trivia Net';return true;\" onMouseOut=\"javascript:top.status='';return true;\">WDI Trivia Net</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/dlr/index.jsp?epi-content=GENERIC&viewID=MY_PORTAL_VIEW&beanID=1872953236\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Commuter Assistance';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Commuter Assistance</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"/davpublish/tpr/publications/disneydesktops/index.html\" target=\"_top\" onMouseOver=\"javascript:top.status='Quick Link: Disney Desktops';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Disney Desktops</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://maxappprd.wdw.disney.com/AutomatedDispatch_Web/OrderForm.aspx?width=1280\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: MAD';return true;\" onMouseOut=\"javascript:top.status='';return true;\">MAD</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://mxesprd.wdw.disney.com/maximo\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Maximo';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Maximo</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"https://wm-flor-ww020/cgi-bin/klxdlrp/ks_iweb.dll?KhalixIdentifier=klxdlrp&KhalixAction=GetSignon&KhalixLangCode=EN&KhalixAuthMode=WinAuth\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: DLR Flash Reporting';return true;\" onMouseOut=\"javascript:top.status='';return true;\">DLR Flash Reporting</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://sena-webapps.wdw.disney.com/LostFound-DLR/login.aspx\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Lost & Found - DLR';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Lost & Found - DLR</a></li>\r\n" +
            "			\r\n" +
            "				<li><a href=\"http://swna-webapps.swna.wdpr.disney.com/lostfound/login.aspx\" target=\"_blank\" onMouseOver=\"javascript:top.status='Quick Link: Lost & Found - WDPR';return true;\" onMouseOut=\"javascript:top.status='';return true;\">Lost & Found - WDPR</a></li>\r\n" +
            "			</ul></small></div>\r\n" +
            "</div>\r\n" +
            "<!-- End Quick Links Module -->\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "					</td>\r\n" +
            "				</tr>\r\n" +
            "\r\n" +
            "	</table>\r\n" +
            "\r\n" +
            "<!-- End Module Chrome -->\r\n" +
            "</td></tr><tr><td>\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "</td></tr><tr><td>\r\n" +
            "\r\n" +
            "    </td>\r\n" +
            "  </tr>\r\n" +
            "</table>\r\n" +
            "<!-- End Quick Access Module -->\r\n" +
            "					</td>\r\n" +
            "				</tr>\r\n" +
            "			</table>\r\n" +
            "		</td>\r\n" +
            "	</tr>\r\n" +
            "\r\n" +
            "	<tr>\r\n" +
            "		<td class=\"mdt_QAP_Footer\">\r\n" +
            "		</td>\r\n" +
            "	</tr>\r\n" +
            "</table>\r\n" +
            "<!-- End Module Chrome -->\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!--\r\n" +
            "############################################################\r\n" +
            "# START: Quick Access Page Control\r\n" +
            "############################################################\r\n" +
            " -->\r\n" +
            "\r\n" +
            "<!--\r\n" +
            "############################################################\r\n" +
            "# END: Quick Access Page Control\r\n" +
            "############################################################\r\n" +
            " -->\r\n" +
            "\r\n" +
            "\r\n" +
            "					\r\n" +
            "				</td>\r\n" +
            "				\r\n" +
            "\r\n" +
            "			</tr>\r\n" +
            "		</table>\r\n" +
            "		<table class=\"grid\" id=\"pageFooter\" description=\"This table is for page layout.\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"2\">\r\n" +
            "			<tr>\r\n" +
            "				<td class=\"footerStyle\" valign=\"bottom\" height=\"1\">\r\n" +
            "					\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<!-- DLR -->\r\n" +
            "\r\n" +
            "\r\n" +
            "<div id=\"footer_main\">    \r\n" +
            "\r\n" +
            "	\r\n" +
            "\r\n" +
            "	<div class=\"moduleSubBanner\">	</div>\r\n" +
            "\r\n" +
            "	<div id=\"footer_copyright1\"> \r\n" +
            "		<br> (c) Disney<br>\r\n" +
            "	</div> \r\n" +
            "\r\n" +
            "	<div id=\"footer_toplinks\">\r\n" +
            "	\r\n" +
            "	\r\n" +
            "	\r\n" +
            "\r\n" +
            "		 <a href=\"index.jsp?epi-content=ADD_CONTENT\">\r\n" +
            "		 	Add a Module</a>\r\n" +
            "         &nbsp;|&nbsp;\r\n" +
            "\r\n" +
            "		<!--  <a href=\"javascript:window.print()\">Print This Page</a>  \r\n" +
            "         &nbsp;|&nbsp; -->\r\n" +
            "         <a href=\"index.jsp?epi-content=GENERIC&beanID=226&viewID=resetform\">\r\n" +
            "         	Contact Us</a>\r\n" +
            "	         <!-- <a href=\"https://backlot.disney.com/community/waltdisneyparksandresorts/thehub\">The Hub Help and Feedback</a> \r\n" +
            "    	     This was required by Comm. Tech at July 2012, but they did not get back to us to push it to PROD,\r\n" +
            "        	 we need to update this file and push to PROD with changes for Cast Tab, this is the reason this is being commented -->\r\n" +
            "          &nbsp;|&nbsp;\r\n" +
            "		  \r\n" +
            "         <a href=\"/site/wdw/index.jsp?epi-content=GENERIC&beanID=901610026&viewID=maximized&wsrp-mode=wsrp:view&wsrp-navigationalState=%2FHub_Request_Center_Service%2Fgeneral%2Findex.do%3Fmethod%3Dhistory&wsrp-windowState=wsrp:maximized\">\r\n" +
            "			The Hub Request Center</a>\r\n" +
            "         \r\n" +
            "		\r\n" +
            "		\r\n" +
            "	</div>	\r\n" +
            "\r\n" +
            "	\r\n" +
            "\r\n" +
            "	<div id=\"footer_bottomlinks\">	\r\n" +
            "		<br>\r\n" +
            "		<a href='/site/dlr/menuitem.0fe1b04e6678832db78936f0faac01ca/&DEPTaxonomyNode-b9a939a7a9c3e616c53f1776faac01ca=570'>\r\n" +
            "			Home</a>\r\n" +
            "		&nbsp;|&nbsp;\r\n" +
            "		<a href='/site/dlr/menuitem.0f4491d48dd84bcbd78936f0faac01ca/&'>\r\n" +
            "			Disneyland Resort</a>\r\n" +
            "\r\n" +
            "		\r\n" +
            "\r\n" +
            "				&nbsp;|&nbsp;\r\n" +
            "				<a href='/site/dlr/menuitem.427e06f258729e615927f59354276099/&'> <!-- Registered user -->\r\n" +
            "					Work</a>\r\n" +
            "			\r\n" +
            "				&nbsp;|&nbsp;\r\n" +
            "				<a href='/site/dlr/menuitem.7d9d49e64fc2cae0c9d358250aac01ca/&'>\r\n" +
            "					Personal</a>\r\n" +
            "\r\n" +
            "			\r\n" +
            "\r\n" +
            "		&nbsp;|&nbsp;\r\n" +
            "		<a href='/site/onesourcedlr/menuitem.34d89a4394ad66884f9ce51077e26099/&'>\r\n" +
            "			Guest</a>\r\n" +
            "		&nbsp;|&nbsp;\r\n" +
            "		\r\n" +
            "		\r\n" +
            "				<a href='/site/dlr/menuitem.682fd220d3b173055d3522870bac01ca/&'> <!-- Registered user -->\r\n" +
            "					Cast</a>	\r\n" +
            "							\r\n" +
            "\r\n" +
            "	</div>\r\n" +
            "\r\n" +
            "	\r\n" +
            "\r\n" +
            "</div> \r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "				</td>\r\n" +
            "			</tr>\r\n" +
            "		</table>\r\n" +
            "		<!-- End Grid Table -->\r\n" +
            "	</body>\r\n" +
            "</html>\r\n" +
            "<script language=\"JavaScript\">\r\n" +
            "var s_account=\"digintranetglobal\"\r\n" +
            "</script>\r\n" +
            "<script language=\"JavaScript\" src=\"/js/omniture/s_code.js\"></script>\r\n" +
            "<script language=\"JavaScript\">\r\n" +
            "     s.pageName=\"\"\r\n" +
            "     s.server=\"\"\r\n" +
            "     s.channel=\"\"\r\n" +
            "     s.pageType=\"\"\r\n" +
            "     s.prop1=\"\"\r\n" +
            "     s.prop21=\"Integrated Schedule View\"\r\n" +
            "     s.prop22=\"\"\r\n" +
            "     s.prop23=\"\"\r\n" +
            "     s.prop24=\"\"\r\n" +
            "     s.prop2=\"C\"\r\n" +
            "     s.prop3=\"PINEJ034\"\r\n" +
            "     s.prop4=\"101\"\r\n" +
            "     s.prop5=\"0113\"\r\n" +
            "     s.prop6=\"Hourly\"\r\n" +
            "     s.prop27=\"Anaheim\"\r\n" +
            "     s.prop28=\"US\"\r\n" +
            "     s.prop14=\"CA\"\r\n" +
            "\r\n" +
            "     s.campaign=\"\"\r\n" +
            "     s.state=\"\"\r\n" +
            "     s.zip=\"\"\r\n" +
            "     s.events=\"\"\r\n" +
            "     s.products=\"\"\r\n" +
            "     s.purchaseID=\"\"\r\n" +
            "     s.eVar1=\"\"\r\n" +
            "     s.eVar2=\"\"\r\n" +
            "     s.eVar3=\"\"\r\n" +
            "     s.eVar4=\"\"\r\n" +
            "     s.eVar5=\"\"\r\n" +
            "     /************* DO NOT ALTER ANYTHING BELOW THIS LINE ! **************/\r\n" +
            "     var s_code=s.t();if(s_code)document.write(s_code)\r\n" +
            "</script>\r\n" +
            "<!-- Total Page Elapsed Time=1727 server=cl-flor-apvm029_inst-06_dlr_6080 webserver=cl-flor-apvm110.disney.pvt -->\r\n" +
            "";

}
