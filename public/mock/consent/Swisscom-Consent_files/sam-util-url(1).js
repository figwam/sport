function callreload(newlang) {
	url = getUrlWithNewParameter(window.location.href, 'lang', newlang);
	url = getUrlWithNewParameter(url, 'languageReload', 'true');
	window.location.href = url;
}

function reloadWithNewParameter(attribute, value) {
	url = getUrlWithNewParameter(window.location.href, attribute, value);
	if (url == window.location.href) {
		window.location.reload();
	}
	window.location.href = url;
}

function getUrlWithNewParameter(url, attribute, value) {
	return getBaseUrl(url) + '?' + getParameters(url, attribute, value)
			+ getAnchor(url);
}

function getParameters(url, attribute, value) {
	url = getUrlWithoutAnchor(url);
	newpair = attribute + '=' + value;
	if (url.indexOf('?') != -1) {
		params = url.substring(url.indexOf('?') + 1);
		paramsArray = params.split('&');
		found = false;
		for ( var u = 0; u < paramsArray.length; u++) {
			pair = paramsArray[u].split('=');
			if (pair[0] == attribute) {
				paramsArray[u] = newpair;
				found = true;
				break;
			}
		}
		if (!found) {
			paramsArray.push(newpair);
		}
		return paramsArray.join('&');
	}
	return newpair;
}

function getBaseUrl(url) {
	url = getUrlWithoutAnchor(url);
	if (url.indexOf('?') == -1) {
		return url;
	}
	return url.substring(0, url.indexOf('?'));
}

function getUrlWithoutAnchor(url) {
	if (url.indexOf('#') != -1) {
		url = url.substring(0, url.indexOf('#'));
	}
	return url;
}

function getAnchor(url) {
	if (url.indexOf('#') != -1) {
		return url.substr(url.indexOf('#'));
	}
	return '';
}