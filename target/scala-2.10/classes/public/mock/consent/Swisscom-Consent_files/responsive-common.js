/** 
 * NOTE: this is a common script included in every page. Keep it slim!
 */
(function(exports) {
	var getEl = function (selector) {
			return $(selector).get(0);
		},
		isIE7 = function () {
			return $("html").hasClass("msIe7");
		},
		isIE = function () {
			return $("html").hasClass("msIe");
		},
		log = function () {
			if (console && console.log) {
				console.log.apply(undefined, arguments);
			}
		},
		hasTouch = function () {  
			try {  
				document.createEvent("TouchEvent");  
				return true;  
			} catch (e) {  
				return false;  
			}  
		},
		toggleClass = function (el, styleClass) {
			var styleClasses = el.className;
			if (styleClasses.indexOf(styleClass) !== -1) {
				el.className = styleClasses.replace(styleClass, "");
			} else {
				el.className = styleClasses + " " + styleClass;
			}
		},
		createElement = function (name, attributes) {
			var el = document.createElement(name),
				name;
			for (name in attributes) {
				el.setAttribute(name, attributes[name]);
			}
			return el;
		},
		createAugmentedFileUpload = function(fileUpload, idCounter) {
			var buttonLabel = fileUpload.data("button-label") || "",
				buttonClass = fileUpload.data("button-class") || "",
				buttonId = "fakeFileuploadButton" + idCounter,
				textfieldClass = fileUpload.data("textfield-class") || "",
				textfield = createElement("input", {
					"class": "sam-fileupload-textfield " + textfieldClass,
					type: "text",
					readonly: "readonly"
				}),
				button = createElement("input", {
					"class": "sam-fileupload-browsebutton sam-button-secondary sam-left-spacer " + buttonClass,
					type: "button",
					value: buttonLabel,
					id: buttonId
				}),
				augmentedFileUpload = {
					textfield: textfield,
					button: button
				};
			
			if (fileUpload.attr("disabled")) {
				augmentedFileUpload.textfield.disabled = "disabled";
				augmentedFileUpload.button.disabled = "disabled";
			}
			
			return augmentedFileUpload;
		},
		augmentFileUploads = function() {
			if (!isIE() || getIeVersion() >= 10) { // ie < 10 applies hard security restrictions on file inputs, see http://stackoverflow.com/questions/3935001/getting-access-is-denied-error-on-ie8/4335390#4335390
				var counter = 1;
				$("input[type=file].sam-augmented-fileupload").each(function () {
					var fileUpload = $(this),
						augmentedFileUpload = createAugmentedFileUpload(fileUpload, counter++);
					
					fileUpload.addClass("sam-offscreen");
					fileUpload.parent().append(augmentedFileUpload.textfield);
					fileUpload.parent().append(augmentedFileUpload.button);
					fileUpload.bind("change", function () {
						var fileName = fileUpload.val();
						
						if (fileName.match(/fakepath/)) {
							fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
						}
						augmentedFileUpload.textfield.value = fileName;
					});
					$(augmentedFileUpload.button).bind("click", function () {
						fileUpload.trigger("click");
					});
				});
			}
		},
		getTooltipOffsetBottomLeft = function (tooltip, padding, trigger, container) {
			var top = trigger.bottom + padding,
				left = trigger.right - tooltip.outerWidth();
			if (left < container.left) { 
				left = container.left+padding;
			}
			return {top:top, left:left};
		},
		getTooltipOffsetTopLeft = function (tooltip, padding, trigger, container) {
			var top = trigger.top - tooltip.outerHeight() - padding,
				left = trigger.right - tooltip.outerWidth();
			if (top < container.top) {
				return getTooltipOffsetBottomLeft(tooltip, padding, trigger, container);
			}
			if (left < container.left) {
				left = container.left+padding;
			}
			return {top:top, left:left};
		},
		getTooltipOffsetBottomRight = function (tooltip, padding, trigger, container) {
			var top = trigger.bottom + padding,
				left = trigger.left;
			if (trigger.left + tooltip.outerWidth() > container.right) {
				left -= (left + tooltip.outerWidth()) - container.right;
			}
			return {top:top, left:left};
		},
		getTooltipOffsetTopRight = function (tooltip, padding, trigger, container) {
			var top = trigger.top - tooltip.outerHeight() - padding,
				left = trigger.left;
			if (top < container.top) {
				return getTooltipOffsetBottomRight(tooltip, padding, trigger, container);
			}
			if (trigger.left + tooltip.outerWidth() > container.right) {
				left -= (left + tooltip.outerWidth()) - container.right;
			}
			return {top:top, left:left};
		},
		getTooltipTrigger = function(toggle) {
			var triggerId = toggle.data('tooltip-referenceid') || toggle.data('contextmenu-referenceid');
			var trigger = $('#'+triggerId);
			if (trigger.length == 0) {
				var toggleSpan = toggle.closest('.sam-info-icon');
				if (toggleSpan.length > 0) {
					trigger = toggleSpan;
				} else {
					trigger = toggle;
				}
			}
			var offset = trigger.offset();
			return {
				"top" : offset.top,
				"bottom" :offset.top+trigger.height(),
				"left" : offset.left,
				"right" : offset.left+trigger.width(),
				"el" : trigger
			};
		},
		getTooltipContainer = function(trigger) {
			var container = trigger.closest(".sam-tooltip-container");
			if (!container || container === '#undefined' || container.length == 0) {
				container = trigger.closest(".sam-overlay");
				if (!container || container === '#undefined' || container.length == 0) {
					container = $("body");
				}
			}
			var offset = container.offset();
			return {
				"top" : offset.top,
				"bottom" :offset.top+container.height(),
				"left" : offset.left,
				"right" : offset.left+container.width(),
				"el" : container
			};
		},
		getTooltip = function(toggle) {
			var tooltipId = toggle.data('tooltip-divid') || toggle.data('contextmenu-divid');
			return $('#'+tooltipId);
		},
		getTooltipToggle = function(ev) {
			return $(ev.target).closest('a');
		},
		getTooltipOffset = function(toggle, tooltip) {
			var padding = 8,
				trigger = getTooltipTrigger(toggle),
				direction = toggle.data('tooltip-direction') || toggle.data('contextmenu-direction'),
				container = getTooltipContainer(trigger.el),
				offset;
			
			if (direction === "topleft") {
				offset = getTooltipOffsetTopLeft(tooltip, padding, trigger, container);
			} else if (direction === "bottomright") {
				offset = getTooltipOffsetBottomRight(tooltip, padding, trigger, container);
			} else if (direction === "bottomleft") {	
				offset = getTooltipOffsetBottomLeft(tooltip, padding, trigger, container);
			} else if (direction === "topright" || typeof direction === "undefined") {   // default = topright
				offset = getTooltipOffsetTopRight(tooltip,  padding, trigger, container);
			} else {
				throw("Unsupported direction: "+direction);
			}
			return offset;
		},
		tooltipsShown = [],
		showTooltip = function(ev) {
			var toggle = getTooltipToggle(ev),
				tooltip = getTooltip(toggle),
				offset = getTooltipOffset(toggle, tooltip);
			hideTooltip();
			tooltipsShown.push(tooltip);
			tooltip.show();
			tooltip.offset(offset);
		},
		hideTooltip = function(ev) {
			$(tooltipsShown).each(function () {
				this.hide();
			});
			tooltipsShown = [];
		},
		toggleTooltip = function(ev) {
			ev.preventDefault();
			ev.stopPropagation();
			var toggle = getTooltipToggle(ev),
				tooltip = getTooltip(toggle),
				shown = tooltip.is(":visible"),
				offset;
			
			hideTooltip();
			if (!shown) {
				offset = getTooltipOffset(toggle, tooltip);
				tooltip.toggle();
				tooltip.offset(offset);
				tooltipsShown.push(tooltip);
			}
		},
		setIeClass = function() {
		    if (scssam.browser.msie) {
		        $('body').addClass('sam-msie' + getIeVersion());
		    }
		},
		getIeVersion = function() {
			if (scssam.browser.msie) {
				return scssam.browser.version.split('.')[0];
			}
			return 0;
		},
		//$.browser in jQuery 1.9 removed please user scssam.browser (same implementation)
		//https://github.com/jquery/jquery/blob/1.8.3/src/deprecated.js
		getUserAgent = function() {
			var ua = navigator.userAgent.toLowerCase(),
				browser = {},
				match,
				matched;
			
			match = /(chrome)[ \/]([\w.]+)/.exec( ua ) ||
	                /(webkit)[ \/]([\w.]+)/.exec( ua ) ||
	                /(opera)(?:.*version|)[ \/]([\w.]+)/.exec( ua ) ||
	                /(msie) ([\w.]+)/.exec( ua ) ||
	                ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec( ua ) ||
	                [];
	        
			matched = {
                browser: match[ 1 ] || "",
                version: match[ 2 ] || "0"
	        };
	        
	        if ( matched.browser ) {
	            browser[ matched.browser ] = true;
	            browser.version = matched.version;
	        }
	        
	        // Chrome is Webkit, but Webkit is also Safari.
	        if ( browser.chrome ) {
	        	browser.webkit = true;
	        } else if ( browser.webkit ) {
	            browser.safari = true;
	        }
	        	        
	        if(ua.match(/android/) !== null) {
	        	browser.android = true;
	        }
	        else if(ua.match(/(iphone|ipad|ipod)/) !== null) {
	        	browser.ios = true;
	        }
	        else if(ua.match(/iemobile/) !== null) {
	        	browser.windowsphone = true;
	        }
	        
	        return browser;
		},
		poller = function(pollFunction, completedFunction, numberOfPolls, initialWait, timeToWait){
			var checkForResult = function(){
				pollFunction(function(completed){
					numberOfPolls--;
					if(completed){
						completedFunction(true);
					}else if(numberOfPolls){
						setTimeout(checkForResult, timeToWait);
					} else{
						completedFunction(false);
					}
				});
			};

			setTimeout(checkForResult, initialWait);
		},
		toggleAkkordeon = function(event) {
			var preopen = $(this).closest('.sam-akkordeon').children('.sam-akkordeon-element.sam-akkordeon-pre-open');
			preopen.children('.sam-akkordeon-title').addClass('sam-akkordeon-open');
			preopen.children('.sam-akkordeon-content').css('display', 'block');
			preopen.removeClass('sam-akkordeon-pre-open');
			if($(this).hasClass('sam-akkordeon-open')) {
				$(this).addClass('sam-akkordeon-closed').removeClass('sam-akkordeon-open');
				var content = $(this).siblings('.sam-akkordeon-content');
				content.slideUp(200, function() {
					content.removeClass('sam-akkordeon-open');
				});
			} else {
				if ($(this).parents('.sam-akkordeon-single-open').length > 0) {
					var title = $(this).closest('.sam-akkordeon').children('.sam-akkordeon-element').children('.sam-akkordeon-title.sam-akkordeon-open')
						.addClass('sam-akkordeon-closed').removeClass('sam-akkordeon-open');
					var content = title.siblings('.sam-akkordeon-content');
					content.slideUp(200, function() {
						content.removeClass('sam-akkordeon-open');
					});
				}
				$(this).addClass('sam-akkordeon-open').removeClass('sam-akkordeon-closed');
				$(this).siblings('.sam-akkordeon-content').slideDown(200);
			}
		},
		toggleTextfieldListitem = function() {
			var value = $(this).val(),
				listItemToggle = $(this).prev("input[type=checkbox], input[type=radio]");
			if (listItemToggle != null) {
				if (value != null && value.length > 0) {
					listItemToggle.attr('checked', 'checked');
				} else {
					listItemToggle.removeAttr('checked');
				}
			}
		},
		jQueryOnOff = function(elem, event, selector, handler) {
			return elem.off(event, selector, handler).on(event, selector, handler);
		},
		registerTooltipHandler = function() {
			var desktop = $('body.DESKTOP');
			if (desktop.length){
				jQueryOnOff(desktop, 'mouseover', '[data-tooltip-divid]', scssam.showTooltip);
				jQueryOnOff(desktop, 'mouseout', '[data-tooltip-divid]', scssam.hideTooltip);
				jQueryOnOff(desktop, 'click', '[data-contextmenu-divid]', scssam.toggleTooltip);
				jQueryOnOff(desktop, 'click', scssam.hideTooltip);
			}
			var tabletPhone = $('body.TABLET, body.PHONE');
			if (tabletPhone.length){
				jQueryOnOff(tabletPhone, scssam.clickEvent, '[data-tooltip-divid]', scssam.toggleTooltip);
				jQueryOnOff(tabletPhone, scssam.clickEvent, '[data-contextmenu-divid]', scssam.toggleTooltip);
				jQueryOnOff(tabletPhone, scssam.clickEvent, scssam.hideTooltip);
			}
		},
		registerAkkordeonHandler = function() {
			var body = $('body');
			jQueryOnOff(body, 'click', '.sam-akkordeon-element .sam-akkordeon-title', toggleAkkordeon);
		},
		registerTextfieldListitemHandler = function() {
			var lists = $('ul.sam-checkbox-list, ul.sam-radio-list, .sam-single-checkbox, .sam-single-radio');
			jQueryOnOff(lists, 'input', 'input[type=text]', toggleTextfieldListitem);
		},
		init = function() {
			setIeClass();
			registerTooltipHandler();
			registerAkkordeonHandler();
			registerTextfieldListitemHandler();
		};
		
	$(function () {
		var navigationIcon = $('.sam-navigation-icon');
		
		if (navigationIcon.length) {
			var page = $("#sam-page").addClass('menu-transition'),
				mobileMenuStyle = $('#navigation').get(0).style;
									
			var transitionHandler = function (e) {
				if(!page.hasClass('menu-open')) {
					mobileMenuStyle.display = 'none';
				}
			};
			
			var navigationExitHandler = function (e) {
				e.preventDefault();
				e.stopPropagation();
				
				page.unbind(scssam.clickEvent, navigationExitHandler);
				$('.menu-transition').removeClass('menu-open');
				navigationIcon.bind(scssam.clickEvent, navigationHandler);
			};
			
			var navigationHandler = function (e) {
				e.preventDefault();
				e.stopPropagation();
				
				navigationIcon.unbind(scssam.clickEvent, navigationHandler);
				mobileMenuStyle.display = 'block';
				$('.menu-transition').addClass('menu-open');
				page.bind(scssam.clickEvent, navigationExitHandler);
			};
			
			navigationIcon.bind(scssam.clickEvent, navigationHandler);
			page.bind('webkitTransitionEnd oTransitionEnd otransitionend transitionend', transitionHandler);
		}
	});
	
	/****************************************
	 * this is the official entry point to provide SAM 
	 * specific javascripts. A single global variable 
	 * should be used by SAM - no more.
	 ****************************************/
	window.scssam = {
		augmentFileUploads: augmentFileUploads,
		showTooltip: showTooltip,
		hideTooltip: hideTooltip,
		toggleTooltip: toggleTooltip,
		ieVersion: getIeVersion,
		browser: getUserAgent(), //$.browser in jQuery 1.9 removed, please use scssam.browser (same implementation)
		clickEvent: (hasTouch() ? "touchend" : "click"),
		util: {
			toggleClass: toggleClass,
			isIE7: isIE7
		},
		poller: poller,
		init: init,
		i18n: {} // object which later holds page specific translations, i.e. see sam-datepicker-i18n-*.js
	};

}(this));

$(function() {
	scssam.init();
});