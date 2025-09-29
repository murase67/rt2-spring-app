/*登録を押したときに確認用ダイアログを表示する
　　OK　　　　　登録内容入力画面に遷移(権限がない場合ログイン画面に遷移される)
　　キャンセル　社員一覧表示画面に遷移*/
function RegistAlert() {
	if (confirm("管理者でない場合ログイン画面に遷移します。")) {
		window.location.href = "/spring_crud/regist/input";
	} else {
		window.location.href = "/spring_crud/list";
	}
}

/*削除を押したときに確認用ダイアログを表示する
　　OK　　　　　削除確認画面に遷移(権限がない場合はFilterによりログイン画面に遷移される)
　　キャンセル　社員一覧表示画面に遷移*/
function DeleteAlert(empId) {
	if (confirm("管理者でない場合ログイン画面に遷移します。")) {
		window.location.href = "/spring_crud/delete/check?empId=" + empId;
	} else {
		window.location.href = "/spring_crud/list";
	}
}

/*ログイン画面のパスワードの表示、非表示をクリックで切り替える*/
document.addEventListener("DOMContentLoaded", function() {
	const toggle = document.getElementById("togglePass");
	const password = document.getElementById("empPass");

	toggle.addEventListener("click", function() {
		if (password.type === "password") {
			password.type = "text";
			toggle.src = "images/visibility.png"; 
		} else {
			password.type = "password";
			toggle.src = "images/visibility_off.png";
		}
	});
});