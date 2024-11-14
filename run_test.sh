#!/bin/bash

# Проверка наличия переданных параметров
if [ $# -lt 3 ]; then
    echo "Использование: $0 <url> <browser_name> <browser_version>"
    exit 1
fi

# Присваиваем параметры командной строки переменным
SELENIUM_GRID_URL=$1
BROWSER_NAME=$2
BROWSER_VERSION=$3

# Логирование
echo "Запуск тестов с следующими параметрами:"
echo "Selenium Grid URL: $SELENIUM_GRID_URL"
echo "Браузер: $BROWSER_NAME"
echo "Версия браузера: $BROWSER_VERSION"

# Запуск Maven тестов с переданными параметрами
mvn clean test -Dselenium.grid.url=$SELENIUM_GRID_URL -Dbrowser.name=$BROWSER_NAME -Dbrowser.version=$BROWSER_VERSION