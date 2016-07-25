<li class="mdl-list__item mdl-list__item--three-line">
    <span class="mdl-list__item-primary-content">
        {!! Form::open(['url'=>'comment']) !!}
            <ul>
                <li>
                    {!! Form::label('post_id', 'Post_id:') !!}
                    {!! Form::text('post_id') !!}

                    {!! Form::label('status', 'Status:') !!}
                    {!! Form::text('status') !!}
                </li>
                <li>
                    {!! Form::label('useragent', 'UserAgent:') !!}
                    {!! Form::text('user_agent') !!}

                    {!! Form::label('content', 'Content:') !!}
                    {!! Form::text('content') !!}

                    {!! Form::submit() !!}
                </li>
            </ul>
        {!! Form::close() !!}
    </span>
</li>