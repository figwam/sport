/**
 * The wrapper ID.
 * This is is internally stored to keep a reference
 * to the content wrapper. (used for external content)
 */
var wId = null;
/**
 * The target is a reference to the remote content.
 * (Used in instant external mask.)
 */
var trgt = null;
/**
 * A reference Object to the Overlay-API.
 * Operations like open() and close() will be
 * executed on this reference.
 * (Used for external mask content.)
 */
var __overlayReference = null;

/**
 * Constructs an overlay-helper object that simplifies dealing with overlays.
 * The element is bound to the DOM (1st element in the body)
 * Note: Since this class strongly depends on jQuery
 * you have to make sure to include jQuery in your page!
 */
function Overlay() {
	this.wrapperId = null;
	this.target = null;
}

///
/// Instance methods for the overlay (helper) object
///

Overlay.prototype.setWrapperId = function(extId) {
	this.wrapperId = extId;
	wId = this.wrapperId;
};

Overlay.prototype.setTarget = function(targetPage) {
	this.target = targetPage;
	trgt = this.target;
};

Overlay.prototype.setOverlayReference = function(overlayReference) {
	__overlayReference = overlayReference;
};


/// 
/// Mask definitions
///

/**
 * The mask object for normal (inline) defined overlays
 */
Overlay.prototype.mask = {
		fixed: false,
		//left: 150,
		top: 110,
		mask: {
			color: '#000',
			loadSpeed: 200,
			opacity: 0.5,
			effect: 'apple'
		},
		closeOnClick: false
};

Overlay.prototype.extendWithSitecatalystCall = function(mask, pagename, channel) {
	newMask = $.extend(true, {}, mask);
	newMask.onLoad = function() {
		// track overlay with sitecatalyst (only if sitecatalyst is loaded)
		if (typeof(s_one) !== 'undefined' && s_one != null) {
			if (pagename != null && channel) {
				s_one.pageName=pagename;
				s_one.channel=channel;
				s_code=s_one.t();if(s_code)document.write(s_code);
			}
		}
	};
	return newMask;
};

/**
 * Mask definition for overlays that need externally loaded content.
 * (Make sure to set the wrapperId before using this element)
 */
Overlay.prototype.externalMask = {
		fixed: false,
		//left: 150,
		top: 110,
		mask: {
			color: '#000',
			loadSpeed: 200,
			opacity: 0.5,
			effect: 'apple',
			left: 'center'
		},
		onBeforeLoad: function() {
			// grab wrapper element inside content
			var wrap = this.getOverlay().find("#" + wId);

			// load the page specified in the trigger
			wrap.load(this.getTrigger().attr("href"));
		},
		
		onLoad: function() {
			// search for elements with class 'close' in the remote content
			// (child elements of the wrapper-element)
			$("#" + wId).find(".close").each(
				function(i) {
					var element = $(this);
					// ...and enable those elements to close the overlay when clicked
					element.click(function() {
						__overlayReference.close();
					});
				}
			);
		},
		
		closeOnClick: false
	};

/**
 * A mask for instantly (as soon as the overlay is created) displaying
 * an overlay with external content (that is content from a remote location).
 */
Overlay.prototype.instantExternalMask = {
		fixed: false,
		//left: 150,
		top: 110,
		mask: {
			color: '#000',
			loadSpeed: 200,
			opacity: 0.5,
			effect: 'apple'
		},
		onBeforeLoad: function() {
			// grab wrapper element inside content
			var wrap = this.getOverlay().find("#" + wId);

			// load the page specified in the trigger
			wrap.load(trgt);
		},
		
		closeOnClick: false,
		load: true
};

/**
 * A mask for instantly (as soon as the overlay is created) displaying
 * an overlay.
 */
Overlay.prototype.instantMask = {
		fixed: false,
		//left: 150,
		top: 110,
		mask: {
			color: '#000',
			loadSpeed: 200,
			opacity: 0.5,
			effect: 'apple'
		},
		closeOnClick: false,
		load: true
};


/**
 * Set the content by downloading the contents of a URL.
 * !!NOTE!! This won't work with any URL violating the SOP.
 * SOP: Same Origin Policy (http://en.wikipedia.org/wiki/Same_origin_policy)
 */
Overlay.prototype.setContentFromUrl = function(url) {
	this.contentDiv.load(url);
};