@extends('template')

@section('content')
    <div class="mdl-cell mdl-cell--12-col mdl-card mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Admin</h2>
        </div>
        <div class="mdl-card__media">
            <img src="../images/contact-image.jpg" alt="Contact Me" border="0" class="article-image">
        </div>

        <div class="mdl-grid portfolio-copy">
            <div class="mdl-cell mdl-cell--8-col mdl-card__supporting-text no-padding">
                <strong> this use to be a dashboard card. </strong>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                Accusantium ad architecto autem consectetur cupiditate dignissimos dolor,
                dolore, eius eum explicabo in, ipsum iure minus nemo quae quibusdam quo reprehenderit voluptatibus?
            </div>
        </div>
    </div>

    <div class="mdl-cell mdl-cell--6-col mdl-card mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Portfolio</h2>
        </div>
        <div class="mdl-card__supporting-text">
            <ul>
                <li><h6>All : 26</h6></li>
                <li><h6>Publish :20</h6></li>
                <li><h6>Draft : 6</h6></li>
            </ul>
        </div>
        <div class="mdl-card__actions mdl-card--border">
            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="">
                create
            </a>

            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="{{--{{ url('post/'.$category->id) }}--}}">
                view all
            </a>
        </div>
    </div>

    <div class="mdl-cell mdl-cell--6-col mdl-card mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Blog</h2>
        </div>
        <div class="mdl-card__supporting-text">
            <ul>
                <li><h6>All : 26</h6></li>
                <li><h6>Publish :20</h6></li>
                <li><h6>Draft : 6</h6></li>
            </ul>
        </div>
        <div class="mdl-card__actions mdl-card--border">
            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="{{ url('post/create') }}">
                create
            </a>

            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="{{ url('admin/post') }}">
                view all
            </a>
        </div>
    </div>

    <div class="mdl-cell mdl-cell--6-col mdl-card mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">User</h2>
        </div>
        <div class="mdl-card__supporting-text">
            <ul>
                <li><h6>All : 26</h6></li>
                <li><h6>sth :20</h6></li>
                <li><h6>sth : 6</h6></li>
            </ul>
        </div>
        <div class="mdl-card__actions mdl-card--border">
            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="">
                create
            </a>

            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="{{--{{ url('post/'.$category->id) }}--}}">
                view all
            </a>
        </div>
    </div>

    <div class="mdl-cell mdl-cell--6-col mdl-card mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Contact</h2>
        </div>
        <div class="mdl-card__supporting-text">
            <ul>
                <li><h6>All : 26</h6></li>
                <li><h6>sth :20</h6></li>
                <li><h6>sth : 6</h6></li>
            </ul>
        </div>
        <div class="mdl-card__actions mdl-card--border">
            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="">
                create
            </a>

            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="{{--{{ url('post/'.$category->id) }}--}}">
                view all
            </a>
        </div>
    </div>
@stop