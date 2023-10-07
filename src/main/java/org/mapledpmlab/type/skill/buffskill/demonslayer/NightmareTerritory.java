package org.mapledpmlab.type.skill.buffskill.demonslayer;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class NightmareTerritory extends BuffSkill {
    public NightmareTerritory() {
        this.setName("나이트메어(마족의 영지)");
        this.setDuration(20L);
    }
}
