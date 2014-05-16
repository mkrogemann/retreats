-module(conway_tests).
-include_lib("eunit/include/eunit.hrl").

evolve_test() ->
    ExpectedGame = true,
    ActualGame = conway:evolve(true),
    ?assertEqual(ExpectedGame, ActualGame).

