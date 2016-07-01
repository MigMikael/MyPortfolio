require 'java'
# require '/Users/manny/NetBeansProjects/CodeRoomDev/build/classes'
# LOAD_PATH.unshift(File.dirname(/Users/manny/NetBeansProjects/CodeRoomDev/build/classes))

obj = Java::CheckAnnotation.new().readFile()

obj.saveJsonFile()