https://www.openshift.com/forums/openshift/play-framework-21-cartridge

cd /var/lib/openshift/536b9d9c4382ec1a6b0002b5/app-root/runtime/repo/

play "start -DapplyEvolutions.default=true -Dhttp.port=8080 -Dhttp.address=${OPENSHIFT_PLAY2_IP}" > $OPENSHIFT_PLAY2_LOG_DIR/play.log

 tail -f */log*/*