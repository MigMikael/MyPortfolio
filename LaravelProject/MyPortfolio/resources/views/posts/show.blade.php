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
            <strong>Category :</strong>
            <a href="{{ url('category') }}">
                <span>{{ $category -> name }}</span>
            </a>
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

    @if($post -> comments)
        <div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp">
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Comments</h2>
            </div>
            <hr>
            <div class="mdl-card__supporting-text">
                <ul class="demo-list-three mdl-list">
                    @foreach($comments as $comment)
                        <li class="mdl-list__item mdl-list__item--three-line">
                            <span class="mdl-list__item-primary-content">
                              <i class="material-icons mdl-list__item-avatar">person</i>
                              <span>{{ $comment -> user_agent }}</span>
                              <span class="mdl-list__item-text-body">
                                {{ $comment -> content }}
                              </span>
                            </span>
                        </li>
                        <hr>
                    @endforeach
                </ul>
                <ul class="demo-list-three mdl-list">
                    @include('comments.create')
                </ul>
            </div>
        </div>
    @endif

@stop