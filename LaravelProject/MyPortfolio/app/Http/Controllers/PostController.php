<?php
namespace App\Http\Controllers;
use App\Post;
use Request;
use Log;
use App\Http\Requests;

class PostController extends Controller {

    public function index()
    {
        $posts = Post::all();
        return view('posts.index')->with('posts', $posts);
    }

    public function create()
    {
        return view('posts.create');
    }
    
    public function store()
    {
        $input = Request::all();

        Post::create($input);

        return redirect('post');
    }
    
    public function show($id)
    {
        $post = Post::find($id);

        return view('posts.show')->with('post', $post);
    }

    public function edit($id)
    {

    }
    
    public function update($id)
    {

    }


    public function destroy($id)
    {

    }
  
}

?>