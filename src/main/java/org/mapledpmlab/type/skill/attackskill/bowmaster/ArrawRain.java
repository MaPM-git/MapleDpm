package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.bowmaster.ArrowRainBuff;

public class ArrawRain extends AttackSkill {
    public ArrawRain() {
        this.setName("애로우 레인");
        this.setAttackCount(7L);
        this.setCooldown(120.0);
        this.setDamage(1540.0);
        this.setDotDuration(70000L);
        this.setInterval(1440L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new ArrowRainBuff());
        // 애로우 레인, 퀴버 카트리지, 모탈 블로우, 파이널 어택 등 미적용
    }
}
