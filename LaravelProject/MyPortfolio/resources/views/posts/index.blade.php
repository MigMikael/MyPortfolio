@extends('template')

@section('content')
    @foreach($posts as $post)
        <div class="mdl-cell mdl-cell--6-col mdl-cell--4-col-phone mdl-cell--4-col-tablet mdl-card mdl-shadow--4dp portfolio-card">
            <div class="mdl-card__media">
                <img class="article-image" src=" ../images/example-work08.jpg" border="0" alt="{{ $post->title }}">
            </div>
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">{{ $post->title }}</h2>
            </div>
            <div class="mdl-card__supporting-text">
                {{ $post->description }}
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="{{ url('post/'.$post->id) }}">
                    Read more
                </a>
            </div>
            <div class="mdl-card__menu">
                <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                    <i class="material-icons">share</i>
                </button>
            </div>
        </div>
    @endforeach

    <div class="mdl-cell mdl-cell--12-col">
        <a href="{{ url('post/create') }}" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
            Create
        </a>
    </div>
@stop