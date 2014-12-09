cd ..

echo call mvn release:prepare -Dmaven.test.skip=true
call mvn release:prepare -Dmaven.test.skip=true

pause