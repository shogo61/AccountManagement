# AccountManagement
アカウント管理を行うJavaのWebアプリケーションです。

主な機能

・新規登録<br>
SignUpServlet<br>
→ID,パスワードなどの情報をDBに保存します<br><br>

・ログイン機能<br>
LoginServlet<br>
→DBを参照してログインを行います<br><br>

・ログアウト機能<br>
LogoutServlet<br>
→セッションを破棄してログアウトを行います<br><br>

・利用者情報変更<br>
InfoChangeServlet<br>
→自分のアカウント情報を変更できます<br><br>

・利用者管理（管理者のみ）<br>
UserManagementServlet<br>
→アカウントの情報を変更したり、アカウントを削除したり復元したりできます<br><br>

・利用者登録（管理者のみ）<br>
UserRegiServlet<br>
→新規登録とほぼ同じですが、新しく管理者を登録することができます<br><br>

その他確認用のServletがいくつかあります。<br><br>

感想<br>
単純なプログラムと違って値をセッションスコープで受け渡さないといけないので大変でした。<br>
今回はあくまでアカウントまわりだけでしたが、コンテンツ部分も作っていけばもっとしっかりしたアプリケーションになりそうです。<br>
