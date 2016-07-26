<?php 

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

Route::get('/', function()
{
	return 'welcome to my website';
});


Route::resource('category', 'CategoryController');
Route::resource('post', 'PostController');
Route::get('admin/post', 'PostController@admin');
Route::resource('comment', 'CommentController');
Route::resource('posttag', 'PostTagController');
Route::resource('tag', 'TagController');
Route::resource('contact', 'ContactController');

Route::get('about', function()
{
    return view('about');
});

Route::get('admin', function()
{
    return view('admin/admin');
});