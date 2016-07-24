@extends('template')

@section('content')
    <h1>All Category</h1>
    <hr>
    @foreach($categories as $category)
        <h3>{{ $category->name }}</h3>
        <p>{{ $category->description }}</p>
    @endforeach
@stop