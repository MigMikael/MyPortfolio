@extends('template')

@section('content')
    @foreach($posts as $post)
        <div class="mdl-cell mdl-card mdl-shadow--4dp portfolio-card">
            <div class="mdl-card__media">
                <img class="article-image" src=" ../images/example-work08.jpg" border="0" alt="">
            </div>
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">{{ $post -> title }}</h2>
            </div>
            <div class="mdl-card__supporting-text">
                {{ $post -> description }}
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="{{ url('post/'.$post -> id) }}">
                    Read more
                </a>
            </div>
        </div>
    @endforeach

    <div class="mdl-cell mdl-cell--12-col">
        <a href="{{ url('post/create') }}" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
            Create
        </a>
    </div>
@stop