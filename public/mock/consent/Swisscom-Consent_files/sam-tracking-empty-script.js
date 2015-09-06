(function (global) {
	var SCS = {};
	SCS.unidata = {
		order: function() {
			SCS.unidata.orderArguments = arguments;
		},
		page: function() {
			SCS.unidata.pageArguments = arguments;
		}
	};
	global.SCS = global.SCS || SCS;
}(this));