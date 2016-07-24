@extends('template')

@section('content')
    <div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">{{ $post -> title }}</h2>
        </div>
        <div class="mdl-card__media">
            <img class="article-image" src="../images/portfolio-example-01.jpg" border="0" alt="">
        </div>
        <div class="mdl-card__supporting-text">
            <strong>Category</strong>
            <span>{{ $post -> category_id }}</span>
        </div>

        <div class="mdl-grid portfolio-copy">
            <h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">Summary</h3>
            <div class="mdl-cell mdl-cell--6-col mdl-card__supporting-text no-padding">
                <p>{{ $post -> summary }}</p>
            </div>
            <div class="mdl-cell mdl-cell--6-col">
                <img class="article-image" src="../images/portfolio-example-02.jpg" border="0" alt="">
            </div>

            <h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">Content</h3>
            <div class="mdl-cell mdl-cell--12-col">
                {!! $post -> content !!}
            </div>
            {{--<h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">Content</h3>
            <div class="mdl-cell mdl-cell--6-col">
                <img class="article-image" src="../images/portfolio-example-03.jpg" border="0" alt="">
            </div>
            <div class="mdl-cell mdl-cell--6-col mdl-card__supporting-text no-padding ">
                <p>{!! $post -> content !!}</p>
            </div>--}}
        </div>
    </div>

    @include('comments.create')

    @if($post -> comments)
        @foreach($comments as $comment)
            <p>{{ $comment -> id }}</p>
            <p>{{ $comment -> post_id }}</p>
            <p>{{ $comment -> content }}</p>
        @endforeach
    @endif

    <h1>ID : {{ $post -> id }}</h1>
    {{--<h1>Title : {{ $post -> title }}</h1>
    <hr>
    <p>Slug : {{ $post -> slug }}</p>
    <p>Description : {{ $post -> description }}</p>
    <p>Summary : {{ $post -> summary }}</p>
    <p>Content : {!! $post -> content !!}</p>
    <p>Status : {{ $post -> status }}</p>--}}
    <p>Comments : {{ $post -> comments }}</p>
    {{--<p>Featured : {{ $post -> featured }}</p>--}}

@stop