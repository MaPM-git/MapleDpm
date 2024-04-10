package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagicCalabash2 extends AttackSkill {
    public MagicCalabash2() {
        this.setName("마봉 호로부(발사)");
        this.setDamage(250.0 + 200 + 570);
        this.setDelayByAttackSpeed(270L);
        this.setAttackCount(6L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
