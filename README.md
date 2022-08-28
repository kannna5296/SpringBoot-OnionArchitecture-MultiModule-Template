# SpringBoot-OnionArchitecutue-MultiModule-Template
Kotlin/SpringBoot/OnionArchitecture用のモジュール分割プロジェクトテンプレート

## 参考にしたもの
* 竹端 尚人さんのブログ
  * [GradleのマルチプロジェクトによるKotlin、Spring Bootでのオニオンアーキテクチャの実現](https://blog.takehata-engineer.com/entry/realizing-an-onion-architecture-in-kotlin-and-spring-boot-with-gradle-multi-project)
* DDD本
  * [ボトムアップでわかる!ドメイン駆動設計の基本](https://www.amazon.co.jp/%E3%83%89%E3%83%A1%E3%82%A4%E3%83%B3%E9%A7%86%E5%8B%95%E8%A8%AD%E8%A8%88%E5%85%A5%E9%96%80-%E3%83%9C%E3%83%88%E3%83%A0%E3%82%A2%E3%83%83%E3%83%97%E3%81%A7%E3%82%8F%E3%81%8B%E3%82%8B-%E3%83%89%E3%83%A1%E3%82%A4%E3%83%B3%E9%A7%86%E5%8B%95%E8%A8%AD%E8%A8%88%E3%81%AE%E5%9F%BA%E6%9C%AC-%E6%88%90%E7%80%AC-%E5%85%81%E5%AE%A3/dp/479815072X/ref=asc_df_479815072X/?tag=jpgo-22&linkCode=df0&hvadid=418292279020&hvpos=&hvnetw=g&hvrand=14096773334611680361&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1009340&hvtargid=pla-878099275802&psc=1&th=1&psc=1)

## モジュール一覧

| モジュール名 | 役割 | 依存先 |
| ---- | ---- | ---- |
| domain | 業務ロジックを記載。ドメイン固有の知識をドメインエンティティとして表現したり、その振る舞いをドメインサービスととして定義したりする。 | なし |
| usecase<br>(application) | アプリケーション固有のロジックを記載。主にドメインエンティティを生成し、infra層に操作を引き渡す。 | domain |
| infra | 主にDBまたはファイルストレージへのデータ永続化などを担当。またAWS/Azureなどのインフラに関わるコードはここに書かれる。 | domain |
| presentation | ユーザへの表示やリクエスト/レスポンスに関わるコードを記載。 | domain,usecase,infra |

※定義は自分の言葉なので間違ってる場合ありです。。ツッコミ・議論大歓迎

## メリデメ
### マルチプロジェクトにするメリット
* Domain/Presentation/Infra/Application層間の依存関係を、build.gradleにより明示的に示せる
  * あらかじめ決められた依存関係に違反したコードはそもそもコンパイルできない

### マルチプロジェクトにするデメリット
* gradle関連の記述ファイルが増えて管理がやや面倒
* ライブラリ管理において、どの層で用いるのか気にしないといけない
  * 全モジュールで用いるのか(ルートディレクトリ/build.gradle/subprojectsに記載)
  * 各モジュールのみそれぞれにのみ必要なのか(各モジュールのbuild.graldに記載)
* Springの仕組み上から、不要な依存関係(Presentation層→Infrastructure層)の追加が必要になる(タケハタさんブログから抜粋)

## 何でこれ作ったん？
* パッとSpringBootのコード書いて検証とかしたくなったときに、SpringInitilizrからの生成だったりパッケージ構成に悩む時間を減らしたい
* マルチモジュールにしたり層分けたりしなきゃもっとパッとプロジェクト立ち上げられるけど、そのデメリットを受けてでも「このコードは何をするコードか？」を考えながらコード書いていたい。このテンプレートをそのための基盤にしたい
