package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SuperFistEnrage extends AttackSkill {
    public SuperFistEnrage() {
        this.setName("슈퍼 피스트 인레이지");
        this.setAttackCount(3L);
        this.setDamage(270.0);
        this.setDelayByAttackSpeed(780L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(20 + 20L);    // 암살-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new SuperFistEnrageShockWave());
    }
}
