find . -name "*.java" > src.txt
javac -sourcepath . @src.txt
java Simulator.Simulator scenario.txt