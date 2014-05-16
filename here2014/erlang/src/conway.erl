-module(conway).

-export([evolve/1]).

%% Export all functions for unit tests
-ifdef(TEST).
-compile(export_all).
-endif.

evolve(Game) ->
    Game.

