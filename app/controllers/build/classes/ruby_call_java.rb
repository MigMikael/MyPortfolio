require 'java'
obj = Java::Java_Parser::CheckAnnotation.new()
obj.readFile()
obj.saveJsonFile()