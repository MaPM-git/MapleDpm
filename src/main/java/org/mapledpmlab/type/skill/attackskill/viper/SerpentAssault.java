package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SerpentAssault extends AttackSkill {
    public SerpentAssault() {
        this.setName("서펜트 어썰트");
        this.setAttackCount(6L);
        this.setDamage(423.0 + 103.0);  // 서펜트 어썰트 인레이지
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
