
function checkLog(log) {
	if (log == "Login") {
		loginShow();
	} else {
		visibility = document.getElementById("userdialog").style.visibility;
		if (visibility == "hidden") {
			userDialogShow();
		} else {
			userDialogHide();
		}
	}
}

function userCheck(log) {
	if (log == "Login") {
		loginShow();
		//window.open("jsp/order.jsp");
	} else {
		window.location.replace("ordercar.jsp");
	}
}
function userDialogShow() {
	document.getElementById("userdialog").style.visibility = 'visible';
	var d = document.getElementById("userdialog");
	d.style.position = "absolute";
	d.style.left = 63+'%';
	d.style.top = 30 + 'px';
}
function userDialogHide() {
	document.getElementById("userdialog").style.visibility = 'hidden';
}

function loginShow() {
	document.getElementById("loginModal").style.visibility = 'visible';
}
function loginHide() {
	document.getElementById("loginModal").style.visibility = 'hidden';
}
function registerShow() {
	loginHide();
	document.getElementById("registerModal").style.visibility = 'visible';
}
function registerHide() {
	document.getElementById("registerModal").style.visibility = 'hidden';
}
function carOrderShow() {
	document.getElementById("carModal").style.visibility = 'visible';
}
function carOrderHide() {
	document.getElementById("carModal").style.visibility = 'hidden';
}
function functionDateDiff() {
	var startDate = document.getElementById("startDate").value;
	var endDate = document.getElementById("endDate").value;

	var oneday = 1000 * 60 * 60 * 24;

	var df = new Date(endDate).getTime() - new Date(startDate).getTime();
	var dd = df / oneday;

	document.getElementById("noOfDays").value = Math.round(dd) + 1;
}
