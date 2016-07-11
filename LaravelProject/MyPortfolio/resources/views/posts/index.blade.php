@extends('template')

@section('content')
    <h1>All Post</h1>
    <hr>
    @foreach($posts as $post)
        <h2>{{ $post -> title }}</h2>
        <p>{{ $post -> description }}</p>
        <a href="{{ url('post/'.$post -> id) }}" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
            View
        </a>
        <hr>
    @endforeach

    <a href="{{ url('post/create') }}" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
        Create
    </a>
@stop