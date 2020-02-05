package com.hussein.youxeltask.di;

import com.hussein.youxeltask.data.repo.LiveMatchesRepository;
import com.hussein.youxeltask.ui.liveMatches.LiveMatchesViewModel;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { MyApplicationModule.class, RepositoryModule.class })
public interface AppComponent {

  LiveMatchesRepository getLiveMatchesRepository();

  void inject(LiveMatchesViewModel liveMatchesViewModel);
}