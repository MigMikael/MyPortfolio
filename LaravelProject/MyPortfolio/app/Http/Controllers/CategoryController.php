<?php

namespace App\Http\Controllers;
use App\Category;
use Request;
use Log;
use App\Http\Requests;

class CategoryController extends Controller
{
    public function index()
    {
        $categories = Category::all();
        return view('category.index')->with('categories', $categories);
    }

    public function create()
    {
        return view('category.create');
    }

    public function store()
    {
        $input = Request::all();

        Category::create($input);

        return redirect('category');
    }
}
