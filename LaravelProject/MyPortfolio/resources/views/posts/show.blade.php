@extends('template')

@section('content')
    <h1>ID : {{ $post -> id }}</h1>
    <h1>Title : {{ $post -> title }}</h1>
    <hr>
    <p>Slug : {{ $post -> slug }}</p>
    <p>Description : {{ $post -> description }}</p>
    <p>Summary : {{ $post -> summary }}</p>
    <p>Content : {{ $post -> content }}</p>
    <p>Status : {{ $post -> status }}</p>
    <p>Comments : {{ $post -> comments }}</p>
    <p>Featured : {{ $post -> featured }}</p>
@stop