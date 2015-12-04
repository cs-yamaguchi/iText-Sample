#!/bin/sh
## NEW PASS SET UP ##########################################
ANT_HOME="/usr/local/apache-ant-1.7.1/"
JAVA_HOME="/opt/wp-log_benesse_ne_jp/java/"
export ANT_HOME
export JAVA_HOME
PATH="$JAVA_HOME/bin:$ANT_HOME/bin:/bin"
export PATH
export CLASSPATH
## COMPILE ##################################################
if [ $# -eq 0 ]; then
	ant
fi
if [ $# -eq 1 ]; then
	ant $1
fi
