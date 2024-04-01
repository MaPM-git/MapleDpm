package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrawlingFearBeforeDelay extends AttackSkill {
    public CrawlingFearBeforeDelay() {
        this.setName("기어 다니는 공포(선딜)");
        this.setDelay(900L);
        this.setCooldown(60.0 - 12);    // 기어 다니는 공포-쿨타임 리듀스
        this.setRelatedSkill(new CrawlingFear());
    }
}
