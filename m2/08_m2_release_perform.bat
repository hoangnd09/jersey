cd ..

echo call mvn release:perform -Darguments=-Ptest.skip
call mvn release:perform -Darguments=-PskipTests=true

pause