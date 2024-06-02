#!/bin/zsh

# :presentation bootRunしている前提
# URLを指定
URL="http://localhost:8080/v3/api-docs.yaml"

# 保存先ディレクトリを指定
DEST_DIR="./apidocs"

# ファイル名を抽出
FILENAME=$(basename "$URL")

# 保存先ファイルパスを作成
DEST_PATH="$DEST_DIR/$FILENAME"

# curlでファイルをダウンロードし、指定のディレクトリに配置
curl -o "$DEST_PATH" "$URL"

# 成功メッセージ
LC_ALL=C echo "ファイルが${DEST_PATH}に保存されました。更新内容を確認してください。"