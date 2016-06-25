module AnnotationHelper

  attr_reader :text

  def as_json(text)
    @text = text
    # class_arr = Array.new()
    # member_arr = Array.new()
    # method = Array.new()
    extract_text
  end

  def extract_text
    text.split("\n").to_json
  end
end
