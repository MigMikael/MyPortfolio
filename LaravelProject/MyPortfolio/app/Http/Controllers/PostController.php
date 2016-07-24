<?php
namespace App\Http\Controllers;
use App\Post;
use App\Category;
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
        $c = Category::all();
        $categories = [];
        for($i = 0; $i < sizeof($c); $i++){
            $categories[$c[$i]['id']] = $c[$i]['name'];
            //Log::info('#### '. $c[$i]['id'].' '.$c[$i]['name']);
        }
        return view('posts.create')->with('categories', $categories);
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