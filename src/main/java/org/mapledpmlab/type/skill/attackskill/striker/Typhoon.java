package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.striker.TyphoonBuff;

public class Typhoon extends AttackSkill {
    public Typhoon() {
        this.setName("태풍");
        this.setAttackCount((5L + 1) * 2);  // 질풍-보너스 어택
        this.setDamage(831.0 + 250);
        this.setDelayByAttackSpeed(390L);
        this.setCooldown(12.0);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
