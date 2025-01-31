package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SerpentAssaultEnrage extends AttackSkill {
    public SerpentAssaultEnrage() {
        this.setName("서펜트 어썰트 인레이지");
        this.setAttackCount(6L);
        this.setDamage(905.0);
        this.setDotDuration(5000L);
        this.setInterval(150L);
        this.setLimitAttackCount(10L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
