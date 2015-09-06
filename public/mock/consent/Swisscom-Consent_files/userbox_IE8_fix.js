/*
 * Overrides function from header.js
 * Fixes jumping logout button in IE8 (lines 15-23)
 * Rest of the function is a 1:1 copy from the initUserBoxEvents function in header.js
 */
scsHeader.profile.initUserBoxEvents = function() {
	var menu = scsHeaderJQuery('#scs-pageheader-userbox-menu');
    if (menu.length > 0) {
        var container = scsHeaderJQuery('#scs-pageheader-userbox');
        var button = scsHeaderJQuery('#scs-pageheader-userbox-button');
        // show/hide menu
        button.click(function() {
            container.toggleClass('isActive');
            
            /*----------------- start fix ------------------*/
            //onMove event tells the PIE to update immediately
            if(window.PIE) {
            	var logoutButton = document.getElementById('scs-pageheader-userbox-logout-button');
            	if (logoutButton != null) {
            		logoutButton.fireEvent('onMove');
            	}
            }
            /*----------------- end fix ------------------*/
            
            this.blur();
        });
        // close menu if something outside the login-box is clicked
        scsHeaderJQuery(document).click(function() {
            container.removeClass('isActive');
        });
        container.click(function(e) {
            e.stopPropagation();
        });
    }
}