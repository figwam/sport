/**
 * (c) Copyright Swisscom (Schweiz) AG. All rights reserved.
 *
 * This product is the proprietary and sole property of Swisscom (Schweiz) AG
 * Use, duplication or dissemination is subject to prior written consent of
 * Swisscom (Schweiz) AG.
 *
 * $Id: sitecatalyst.js
 */
scsHeaderJQuery.namespace("scsHeader.siteCatalyst");

scsHeader.siteCatalyst.PAGE_LOAD_DELAY = 1000;

scsHeader.siteCatalyst.trackClick = function track(me, e, link, area) {
	var $ = scsHeaderJQuery;
    var $this = $(me);
    if ($this.is(".active")) {
        return;
    }

    e.preventDefault();
    if (window.s_one) {
        s_one.linkTrackVars = 'prop8,prop9,eVar45,eVar46';
        s_one.prop8 = area + '_' + link;
        if (s_one.prop21) {
        	// when the user is not logged in, prop21
        	// is not set. We use prop20 as a fallback.
        	s_one.prop9 = area + '_' + s_one.prop21;
        } else {
        	s_one.prop9 = area + '_' + s_one.prop20;
        }
        
        if (area == 'MDD') {
        	if (s_one.prop21.indexOf(':') !== -1) {
	        	var level0 = s_one.prop21.split(':')[1];
	        	s_one.prop9 = area + '_' + level0;
        	}
        }
        
        s_one.eVar45 = s_one.prop8;
        s_one.eVar46 = s_one.prop9;
        s_one.tl(me, 'o', 'Clicks in ' + area);
    }

    var destination = $this.attr('href');
    var target = $this.attr('target') || "_self";
    var isNewTab = e.ctrlKey || e.metaKey;

    //maybe needs to be delayed by 100-200ms (google tracking experience)
    setTimeout(function() {
        if (isNewTab) {
            window.open(destination);
        }
        else {
            window.open(destination, target);
        }
    }, scsHeader.siteCatalyst.PAGE_LOAD_DELAY);
};

scsHeader.siteCatalyst.initHeaderTracking = function() {
	var $ = scsHeaderJQuery;
    $(document).delegate('#scs-pageheader-toolsnav a, #scs-pageheader-metanav a, #scs-pageheader-branchnav a, #scs-pageheader-language-switch a', 'click', function(e) {
        scsHeader.siteCatalyst.trackClick(this, e, $(this).data('trackingLinkName'), 'Toolbar');
    });

    $('#scs-pageheader-topnav a').live('click', function(e) {
        scsHeader.siteCatalyst.trackClick(this, e, $(this).data('trackingTitle'), 'MDD');
    });
};

scsHeaderJQuery(function($) {
    if ($('body').hasClass('cq_isEditMode')) {
        return;
    }
    scsHeader.siteCatalyst.initHeaderTracking();
});