class AnnotationController < ApplicationController
require 'json'
  def call_java_check
    output = `java -cp "/Users/manny/Documents/Work/ruby/CodeRoomDev/build/classes" java_parser.CheckAnnotation`
    text_file = File.new('/Users/manny/Documents/Work/ruby/CodeRoomDev/CodeRoomDev/json_file.txt', "r").read
    # puts JSON.parse(text_file)
    # puts @text
    # @text = text_file.to_json
    @text= {class:[{modifier:"deafult",name:"A", member:[{modifier:"public",datatype:"int",name:"x"},{modifier:"private",datatype:"double",name:"man"}],method:[modifier:"public",returntype:"string",name:"printV1",parms:[{datatype:"string[]",name:"x"},{datatype:"int",name:"y"},]]}]}

    respond_to do |format|
      # @text = text_file.to_json
      # format.html # index.html.erb
      # format.xml  { render :xml => @somearray }
      format.json  { render :json =>  text_file.as_json }
    end
    # obj.readFile()
    # obj.saveJsonFile()
  end

end
