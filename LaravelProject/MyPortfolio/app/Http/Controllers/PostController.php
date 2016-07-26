<?php
namespace App\Http\Controllers;
use App\Post;
use App\Category;
use App\Comment;
use Request;
use Log;
use App\Http\Requests;

class PostController extends Controller {

    public function index()
    {
        $posts = Post::where('status', '=', 'publish')->orderBy('created_at', 'desc')->get();
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
        //Log::info('*** '. $post['comments']);
        $category = Category::findOrFail($post['category_id']);
        //Log::info('*** '. $category['name']);

        if($post['comments']) {
            $comments = Comment::where('post_id', '=', $post['id'])->get();
            return view('posts.show')->with('post', $post)->with('comments', $comments)->with('category', $category);
        }
        else {
            return view('posts.show')->with('post', $post)->with('category', $category);
        }
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

    public function admin()
    {
        $posts = Post::orderBy('created_at', 'desc')->get();
        //$posts = Post::all()->orderBy('created_at', 'desc')->get(); wrong usage
        return view('admin/post')->with('posts', $posts);
    }
  
}

?>