package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MightyMjolnir extends AttackSkill {
    public MightyMjolnir() {
        this.setName("마이티 묠니르(첫타)");
        this.setAttackCount(6L);
        this.setDamage(535.0);
        this.setFinalDamage(1.6);   // 코어 강화
    }
}
