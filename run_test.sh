#!/bin/bash

# Проверка переменных окружения или использование значений по умолчанию
SELENIUM_GRID_URL=${SELENIUM_GRID_URL:-"http://localhost:4444/wd/hub"}
BROWSER_NAME=${BROWSER_NAME:-"chrome"}
BROWSER_VERSION=${BROWSER_VERSION:-"124.0"}

# Логирование
echo "Running tests with the following configuration:"
echo "Selenium Grid URL: $SELENIUM_GRID_URL"
echo "Browser: $BROWSER_NAME"
echo "Browser Version: $BROWSER_VERSION"

# Запуск Maven тестов с параметрами
mvn clean test -Dselenium.grid.url=$SELENIUM_GRID_URL -Dbrowser.name=$BROWSER_NAME -Dbrowser.version=$BROWSER_VERSION
