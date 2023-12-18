package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackMagicAltarDelay extends AttackSkill {
    public BlackMagicAltarDelay() {
        this.setName("블랙 매직 알터");
        this.setDelay(540L * 3);        // 4개 설치
    }
}
