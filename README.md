# AccountManagement
アカウント管理を行うJavaのWebアプリケーションです。

主な機能

・新規登録

SignUpServlet

→ID,パスワードなどの情報をDBに保存します


・ログイン機能

LoginServlet

→DBを参照してログインを行います


・ログアウト機能

LogoutServlet

→セッションを破棄してログアウトを行います


・利用者情報変更

InfoChangeServlet

→自分のアカウント情報を変更できます


・利用者管理（管理者のみ）

UserManagementServlet

→アカウントの情報を変更したり、アカウントを削除したり復元したりできます


・利用者登録（管理者のみ）

UserRegiServlet

→新規登録とほぼ同じですが、新しく管理者を登録することができます



その他確認用のServletがいくつかあります。



感想

単純なプログラムと違って値をセッションスコープで受け渡さないといけないので大変でした。

今回はあくまでアカウントまわりだけでしたが、コンテンツ部分も作っていけばもっとしっかりしたアプリケーションになりそうです。
