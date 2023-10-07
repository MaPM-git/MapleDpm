package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.demonslayer.NightmareTerritory;

public class NightmareWaveDelay extends AttackSkill {
    public NightmareWaveDelay() {
        this.setName("나이트메어(파동)");
        this.setDelay(3000L);
        this.setRelatedSkill(new NightmareTerritory());
    }
}
